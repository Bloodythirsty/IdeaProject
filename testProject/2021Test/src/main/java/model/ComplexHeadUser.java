package model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author zhangkangkang created on 2021/3/7 4:04 下午
 */
@Data
@Builder
public class ComplexHeadUser {

    @ExcelProperty(value = {"用户信息","用户主题1","用户编号"})
    private Integer userId;

    @ExcelProperty(value = {"用户信息","用户主题2","用户名"})
    private String userName;

    @ExcelProperty(value = {"用户信息","用户主题2","工资"})
    private Double salary;
}
