package testEasyPoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.google.common.collect.Lists;
import model.User;
import model.User2;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author zhangkangkang created on 2021/3/9 11:27 下午
 */
public class TestEasyPoi {

    @Test
    public void testAppend() throws IOException {
//        FileInputStream fs=new FileInputStream();  //获取d://test.xls
//        POIFSFileSystem ps=new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息


        List<User2> users = Lists.newArrayList(
                User2.builder().userId(1).userName("kk1").gender("男").hireDate(DateTime.now().toDate()).salary(111.0).build(),
                User2.builder().userId(2).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(112.0).build(),
                User2.builder().userId(3).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(113.0).build(),
                User2.builder().userId(4).userName("kk4").gender("男").hireDate(DateTime.now().toDate()).build()
        );

        XSSFWorkbook workbook = new XSSFWorkbook("user3.xlsx");
//        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(workbook);

        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(0);
        String sheetName = sheet.getSheetName();
        System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());
//
        FileOutputStream fileOutputStream = new FileOutputStream("user3.xlsx");
        row = sheet.createRow(sheet.getLastRowNum()+1);
        row.createCell(0).setCellValue("123");

        fileOutputStream.flush();
        workbook.write(fileOutputStream);

    }
}
