package testExcell;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.google.common.collect.Lists;
import model.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.joda.time.DateTime;
import org.junit.Test;
import utils.Excelutils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangkangkang created on 2021/3/7 5:04 下午
 */
public class TestExcelRead {

    /**
     * 读取
     */
    @Test
    public void testRead1(){
        String fileName = "user4.xlsx";

        //读取
        EasyExcel.read(fileName, User.class, new AnalysisEventListener() {
            /**
             * 每解析一行excel表格，调用一次
             * @param o
             * @param analysisContext
             */
            public void invoke(Object o, AnalysisContext analysisContext) {
                System.out.println("解析数据 = " + o);
            }

            /**
             * 全部解析完，被调用
             * @param analysisContext
             */
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println(" 全部解析完被调用 ");
            }
        }).sheet().doRead();

        System.out.println(" ========================================================= ");

        //方式二
        ExcelReader excelReader = EasyExcel.read(fileName, User.class, new AnalysisEventListener() {
            public void invoke(Object o, AnalysisContext analysisContext) {
                System.out.println("解析数据 = " + o);
            }

            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println(" 全部解析完被调用 ");
            }
        }).build();

        ReadSheet readSheet = EasyExcel.readSheet(0).build();

        excelReader.read(readSheet);

        excelReader.finish();
    }


    @Test
    public void testRead2(){
        String fileName = "user1.xlsx";

        final List<User> list = Lists.newArrayList();

        //读取
        ExcelReader excelReader = EasyExcel.read(fileName, User.class, new AnalysisEventListener() {
            public void invoke(Object o, AnalysisContext analysisContext) {
                list.add((User)o);
            }

            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).build();
        //
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        //
        excelReader.read(readSheet);

        excelReader.finish();

    }

    @Test
    public void testAppend(){


        String fileName = "user1.xlsx";

        List<User> list = Lists.newArrayList();

         list = Excelutils.readLocalExcelFile(fileName, User.class, 0);

        //=============================================================================
        List<User> users = Lists.newArrayList();
        for (int i = 0; i < 100000; i++) {
            users.add(User.builder().userId(21000000+i).userName("kk1"+i).gender("男").hireDate(DateTime.now().toDate()).salary(111.0).build());
        }


        // 合并
        boolean b = CollectionUtils.addAll(list, users.iterator());

        List<String> includeColunms = Lists.newArrayList("hireDate","salary","gender","userName","userId");

        //写入
        Excelutils.writeLocalExcelFile(fileName,User.class,0,list, includeColunms);

    }

    @Test
    public void testUtils() {
        List<User> users = Excelutils.readLocalExcelFile("user1.xlsx", User.class, 2);
        System.out.println("users.size() = " + users.size());
    }
}
