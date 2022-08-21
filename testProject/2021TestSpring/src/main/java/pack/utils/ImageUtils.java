package pack.utils;


import com.madgag.gif.fmsware.GifDecoder;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.util.FileUtil;
import org.springframework.web.multipart.MultipartFile;
import pack.bean.ImageInfoDto;
import pack.constants.ImageSuffixEnum;
import pack.constants.SystemConstants;
import pack.exception.BizException;

@Slf4j
public class ImageUtils {
    private static final long UPLOAD_IMAGE_FILE_MAX_SIZE = 10 * 1024 * 1024L;


    public static File transBase64(String imgStr) throws IOException {

        byte[] b = Base64.getDecoder().decode(imgStr);
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {//调整异常数据
                b[i] += 256;
            }
        }
        String newFileName = UUID.randomUUID().toString().substring(0, 8) + ".jpeg";
        File targetDir = new File(SystemConstants.TEMP_FILE_PATH_PREFIX);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        File targetFile = new File(SystemConstants.TEMP_FILE_PATH_PREFIX, newFileName);
        //生成jpeg图片
        OutputStream out = new FileOutputStream(targetFile);
        out.write(b);
        out.flush();
        out.close();
        return targetFile;
    }

    public static File saveOnLocal(MultipartFile file,
                                   HttpServletRequest request) throws IOException {
        if (file.getSize() > UPLOAD_IMAGE_FILE_MAX_SIZE) {
            throw new BizException("图片大小不能超过10M");
        }
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        String suffix = ImageUtils.getImageSuffix(fileName);
        if (StringUtils.isEmpty(suffix)) {
            throw new BizException("图片格式不正确");
        }
        String newFileName = UUID.randomUUID().toString().substring(0, 8) + suffix;
        File targetDir = new File(path);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        File targetFile = new File(path, newFileName);
        file.transferTo(targetFile);
        return targetFile;
    }

    public static ImageInfoDto getImageInfo(File file) throws IOException {
        String suffix = getImageSuffix(file.getName());
        int[] wh = getWidthHeight(file, suffix);
        int size = getImageSize(file);
        return ImageInfoDto.builder()
                .size(size)
                .width(wh[0])
                .height(wh[1])
                .suffix(suffix)
                .build();

    }

    public static int getImageSize(File file) throws IOException {
        byte[] srcImageData = FileUtil.readAsByteArray(file);
        return srcImageData.length;
    }


    private static BufferedImage getBufferImage(File file, String suffix) throws IOException {
        if (Objects.equals(suffix, ImageSuffixEnum.GIF.getSuffix())) {
            GifDecoder d = new GifDecoder();
            d.read(file.getPath());
            BufferedImage frame = d.getFrame(0);
            return frame;
        } else {
            FileInputStream is = new FileInputStream(file);
            BufferedImage bufferedImage = ImageIO.read(is);
            if (is != null) {
                is.close();
            }
            return bufferedImage;
        }
    }

    public static int[] getWidthHeight(File file, String suffix) throws IOException {
        int[] wh;
        try {
            BufferedImage sourceImg = getBufferImage(file, suffix);
            if (sourceImg != null) {
                wh = new int[]{sourceImg.getWidth(), sourceImg.getHeight()};
                sourceImg.flush();
                return wh;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            log.warn("读取文件宽高异常" + file.getName(), e);
            return new int[]{0, 0};
        }
        return new int[]{0, 0};
    }

    public static String getImageSuffix(String fileName) {
        if (fileName == null) {
            return null;
        }
        ImageSuffixEnum imageSuffixEnum = ImageSuffixEnum.parse(fileName.toLowerCase());
        if (imageSuffixEnum != null) {
            return imageSuffixEnum.getSuffix();
        }
        return null;
    }


}
