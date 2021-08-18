package model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.sound.midi.Soundbank;
import java.util.Date;

/**
 * @author zhangkangkang created on 2021/3/7 3:27 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ExcelProperty(value = "用户编号")
    private Integer userId;

    @ExcelProperty(value = "用户名")
    private String userName;

    @ExcelProperty(value = "性别")
    private String gender;

    @NumberFormat("#.##")
    @ExcelProperty(value = "工资")
    private double salary;

//    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty(value = "雇佣日期")
    private Date hireDate;

    private void write(){
        System.out.println("1");
    }
}
