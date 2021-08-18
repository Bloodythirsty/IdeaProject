package pack._2021testspring.water;

import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhangkangkang created on 2021/2/5 3:40 下午
 */
public class Tests {
    public static void main(String[] args) throws IOException {

        FontImage.Watermark watermark = FontImage.Watermark.builder().text("zhangkangkang_i@didigloable.com").build();
        BufferedImage image = FontImage.createWatermarkImage(watermark);
        // 导出到字节流B
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "png", os);

        FileOutputStream fileOutputStream = new FileOutputStream("test.png");
        ImageIO.write(image,"png",fileOutputStream);

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("xx市-身份证号码_1608532479608.xlsx"));

//        FileOutputStream outputStream2 = new FileOutputStream("空.xls");
//        workbook.write(outputStream2);

        int pictureIdx = workbook.addPicture(os.toByteArray(), Workbook.PICTURE_TYPE_PNG);
        POIXMLDocumentPart poixmlDocumentPart = workbook.getAllPictures().get(pictureIdx);
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {//获取每个Sheet表
            XSSFSheet sheet = workbook.getSheetAt(i);
            PackagePartName ppn = poixmlDocumentPart.getPackagePart().getPartName();
            String relType = XSSFRelation.IMAGES.getRelation();
            //add relation from sheet to the picture data
            PackageRelationship pr = sheet.getPackagePart().addRelationship(ppn, TargetMode.INTERNAL, relType, null);
            //set background picture to sheet
            sheet.getCTWorksheet().addNewPicture().setId(pr.getId());
        }
        FileOutputStream outputStream = new FileOutputStream("test.csv");
        workbook.write(outputStream);


        File file = new File("test.xls");
        file.setWritable(false);
        file.setReadOnly();
        file.setExecutable(false);

    }
}
