package testExcell;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import model.ComplexHeadUser;
import model.User;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;

/**
 * @author zhangkangkang created on 2021/3/7 3:32 下午
 */
public class TestExcelWrite {

    // 方式1
    @Test
    public void testWrite1(){
        String fileName = "user1.xlsx";

        //构建数据
//        List<User> users = Lists.newArrayList(
//                User.builder().userId(1).userName("kk1").gender("男").hireDate(DateTime.now().toDate()).salary(111.0).build(),
//                User.builder().userId(2).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(112.0).build(),
//                User.builder().userId(3).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(113.0).build(),
//                User.builder().userId(4).userName("kk4").gender("男").hireDate(DateTime.now().toDate()).build()
//        );

        List<User> users = Lists.newArrayList();
        for (int i = 0; i < 100000; i++) {
            users.add(User.builder().userId(i).userName("kk"+i).gender("男").hireDate(DateTime.now().toDate()).salary(i).build());
        }

        //写
        EasyExcel.write(fileName,User.class).sheet("用户信息").doWrite(users);
    }

    // 方式2
    @Test
    public void testWrite2(){
        String fileName = "user2.xlsx";

        //构建数据
        List<User> users = Lists.newArrayList(
                User.builder().userId(5).userName("kk1").gender("男").hireDate(DateTime.now().toDate()).salary(111.0).build(),
                User.builder().userId(2).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(112.0).build(),
                User.builder().userId(3).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(113.0).build(),
                User.builder().userId(4).userName("kk4").gender("男").hireDate(DateTime.now().toDate()).build()
        );

        ExcelReaderBuilder readerBuilder = EasyExcel.read(fileName);
        ExcelReaderSheetBuilder sheetBuilder = readerBuilder.sheet("用户信息2");
        sheetBuilder.doRead();

        //创建excel写对象
        ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).build();
        // 创建sheet写对象
        WriteSheet writeSheet = EasyExcel.writerSheet("用户信息2").build();
        // 合并
        ExcelWriter write = excelWriter.write(users, writeSheet);
        // 关闭
        excelWriter.finish();

    }

    // 方式3 : 排除掉一些列
    @Test
    public void testWrite3(){
        String fileName = "user3.xlsx";

        //构建数据
        List<User> users = Lists.newArrayList(
                User.builder().userId(1).userName("kk1").gender("男").hireDate(DateTime.now().toDate()).salary(111.0).build(),
                User.builder().userId(2).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(112.0).build(),
                User.builder().userId(3).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(113.0).build(),
                User.builder().userId(4).userName("kk4").gender("男").hireDate(DateTime.now().toDate()).salary(114.0).build()
        );

        Set<String> excludeColumn = Sets.newHashSet("hireDate", "salary");

        //创建excel写对象
        EasyExcel.write(fileName, User.class)
                .excludeColumnFiledNames(excludeColumn)
                .sheet("用户信息3")
                .doWrite(users);
    }

    // 方式4 : 只写入指定的列
    @Test
    public void testWrite4(){
        String fileName = "user4.xlsx";

        //构建数据
        List<User> users = Lists.newArrayList(
                User.builder().userId(1).userName("kk1").gender("男").hireDate(DateTime.now().toDate()).salary(111.0).build(),
                User.builder().userId(2).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(112.0).build(),
                User.builder().userId(3).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(113.0).build(),
                User.builder().userId(4).userName("kk4").gender("男").hireDate(DateTime.now().toDate()).salary(114.0).build()
        );

        Set<String> incldeColumn = Sets.newHashSet("hireDate", "salary");

        //创建excel写对象
        EasyExcel.write(fileName, User.class)
                .includeColumnFiledNames(incldeColumn)
                .sheet("用户信息4")
                .doWrite(users);
    }


    // 方式5 : 调换excel的column位置
    // 注解中excelProperty中指定index：从0开始
    @Test
    public void testWrite5(){
        String fileName = "user5.xlsx";

        //构建数据
        List<User> users = Lists.newArrayList(
                User.builder().userId(1).userName("kk1").gender("男").hireDate(DateTime.now().toDate()).salary(111.0).build(),
                User.builder().userId(2).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(112.0).build(),
                User.builder().userId(3).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(113.0).build(),
                User.builder().userId(4).userName("kk4").gender("男").hireDate(DateTime.now().toDate()).salary(114.0).build()
        );

        //创建excel写对象
        EasyExcel.write(fileName, User.class)
                .sheet("用户信息4")
                .doWrite(users);
    }

    // 方式6 : 复杂头
    @Test
    public void testWrite6(){
        String fileName = "complexUser1.xlsx";

        //构建数据
        List<ComplexHeadUser> users = Lists.newArrayList(
                ComplexHeadUser.builder().userId(1).userName("kk1").salary(111.0).build(),
                ComplexHeadUser.builder().userId(2).userName("kk2").salary(112.0).build(),
                ComplexHeadUser.builder().userId(3).userName("kk3").salary(113.0).build()
        );

        //创建excel写对象
        EasyExcel.write(fileName, ComplexHeadUser.class)
                .sheet("用户信息4")
                .doWrite(users);
    }


    // 方式7 : 讲数据重复写入同一个sheet
    @Test
    public void testWrite7(){
        String fileName = "complexUser7.xlsx";

        //构建数据
        List<ComplexHeadUser> users = Lists.newArrayList(
                ComplexHeadUser.builder().userId(1).userName("kk1").salary(111.0).build(),
                ComplexHeadUser.builder().userId(2).userName("kk2").salary(112.0).build(),
                ComplexHeadUser.builder().userId(3).userName("kk3").salary(113.0).build()
        );

        //创建excel写对象
        ExcelWriter excelWriter = EasyExcel.write(fileName,ComplexHeadUser.class).build();
        // 创建sheet写对象
        WriteSheet writeSheet = EasyExcel.writerSheet("信息7").build();
        // 重复写入
        for (int i = 0; i < 5; i++) {
            excelWriter.write(users,writeSheet);
        }
        // 关流
        excelWriter.finish();
    }


    // 方式8 : 讲数据重复写入同一个excel的不同sheet中
    @Test
    public void testWrite8(){
        String fileName = "complexUser8.xlsx";

        //构建数据
        List<ComplexHeadUser> users = Lists.newArrayList(
                ComplexHeadUser.builder().userId(1).userName("kk1").salary(111.0).build(),
                ComplexHeadUser.builder().userId(2).userName("kk2").salary(112.0).build(),
                ComplexHeadUser.builder().userId(3).userName("kk3").salary(113.0).build()
        );

        //创建excel写对象
        ExcelWriter excelWriter = EasyExcel.write(fileName,ComplexHeadUser.class).build();
        // 创建sheet写对象
        WriteSheet writeSheet1 = EasyExcel.writerSheet("信息7").build();
        WriteSheet writeSheet2 = EasyExcel.writerSheet("信息8").build();
        // 重复写入
        excelWriter.write(users,writeSheet1).write(users,writeSheet2);
        // 关流
        excelWriter.finish();
    }

    // 方式9 : 日期数字格式化
    // DateTimeFormat  NumberFormat
    @Test
    public void testWrite9(){
        String fileName = "user9.xlsx";

        //构建数据
        List<User> users = Lists.newArrayList(
                User.builder().userId(1).userName("kk1").gender("男").hireDate(DateTime.now().toDate()).salary(111.111).build(),
                User.builder().userId(2).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(112.111).build(),
                User.builder().userId(3).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(113.222).build(),
                User.builder().userId(4).userName("kk4").gender("男").hireDate(DateTime.now().toDate()).salary(114.333).build()
        );

        //创建excel写对象
        EasyExcel.write(fileName, User.class)
                .sheet("用户信息1")
                .doWrite(users);
    }

    // 方式10 : 根据已经存在模版填充数据
    // sheet名字和已经存在的要一样，且不再加class属性
    @Test
    public void testWrite10() throws FileNotFoundException {
        String fileName = "user10.xlsx";

        //构建数据
        List<User> users = Lists.newArrayList(
                User.builder().userId(1).userName("kk1").gender("男").hireDate(DateTime.now().toDate()).salary(111.111).build(),
                User.builder().userId(2).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(112.111).build(),
                User.builder().userId(3).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(113.222).build(),
                User.builder().userId(4).userName("kk4").gender("男").hireDate(DateTime.now().toDate()).salary(114.333).build()
        );

        File file = new File("template.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);

        //创建excel写对象
//        EasyExcel.write(fileName,User.class).withTemplate(fileInputStream).sheet("用户信息").doWrite(users);
        // 上面方式出现两个头，所以用了模版就不用class
        EasyExcel.write(fileName,User.class).withTemplate(fileInputStream).sheet("用户信息").doWrite(users);
    }

}
