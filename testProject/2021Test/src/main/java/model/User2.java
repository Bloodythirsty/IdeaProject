package model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangkangkang created on 2021/3/7 3:27 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User2  implements Serializable {

    @Excel(name = "用户id")
    private int userId;

    @Excel(name = "用户名")
    private String userName;

    @Excel(name = "性别")
    private String gender;

    @Excel(name = "工资")
    private double salary;

    @Excel(name = "雇佣日期")
    private Date hireDate;
}
