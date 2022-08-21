package pack.service;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pack.bean.ImageInfoDto;
import pack.constants.ImageSuffixEnum;
import pack.utils.ImageUtils;

/**
 * @description:
 * @author: zhaobofan
 * @create: 2020/7/6 20:33
 **/
@Service
@Slf4j
public class PictureServiceImpl implements PictureService, InitializingBean {

    private static final int MAX_IMAGE_WIDTH = 1024;


    @Override
    public void uploadAndSave(File file) throws IOException {
        ImageInfoDto orgFileInfo = ImageUtils.getImageInfo(file);
        log.info("orgFileInfo:{}", orgFileInfo);
        log.info(file.getName());
        if (!Objects.equals(orgFileInfo.getSuffix(), ImageSuffixEnum.GIF.getSuffix())) {
            //如果图片不是gif,压缩到<=1024像素宽度
//            file = imageSizeHandler.compressByWidth(file, orgFileInfo, MAX_IMAGE_WIDTH);
        }
        //上传
        ImageInfoDto fileInfo = ImageUtils.getImageInfo(file);
        //保存
    }


    /**
     * 清理文件
     *
     * @param file
     */
    private void clear(File file) {
        if (Objects.nonNull(file) && file.exists()) {
            file.delete();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        File docu = new File("/Users/zhangkangkang/Documents/jpeg");
//        File[] files = docu.listFiles();
//        for (File file : files) {
//            uploadAndSave(file);
//        }
    }
}
