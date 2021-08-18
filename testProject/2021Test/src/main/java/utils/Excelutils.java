package utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhangkangkang created on 2021/3/10 11:50 上午
 */
public class Excelutils {

    public static <T> List<T> readLocalExcelFile(String completePath, Class<T> tClass, int sheetNum){
        final List<T> list = Lists.newArrayList();
        try{
            ExcelReader excelReader = EasyExcel.read(completePath, tClass, new AnalysisEventListener() {
                @Override
                public void invoke(Object data, AnalysisContext context) { list.add((T)data); }

                @Override
                public void doAfterAllAnalysed(AnalysisContext context) { }
            }).build();
            ReadSheet readSheet = EasyExcel.readSheet(sheetNum).build();
            excelReader.read(readSheet);
            excelReader.finish();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }

    public static <T> void  writeLocalExcelFile(String completePath,Class<T> tClass, int sheetNum, List<T> data, List<String> includeColumns){
        EasyExcel.write(completePath, tClass).includeColumnFiledNames(includeColumns).sheet(sheetNum).doWrite(data);
    }
}
