package pack._2021testspring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangkangkang created on 2021/3/1 5:00 下午
 * 判断前端传递过来要查询的字段：0：不查询，1：查询
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverInfoDownloadDriverItemsVo {

    /**
     * 姓名
     */
    private int name;

    /**
     * 性别：1：男，0：女
     */
    private int gender;

    /**
     * 司机手机号
     */
    private int driverPhone;

    /**
     * 司机身份证号
     */
    private int idCardNo;
}
