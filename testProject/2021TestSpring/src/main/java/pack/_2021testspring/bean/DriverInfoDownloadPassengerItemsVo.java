package pack._2021testspring.bean;

import lombok.Data;

/**
 * @author zhangkangkang created on 2021/3/1 5:02 下午
 * 判断前端传递过来要查询的字段：0：不查询，1：查询
 */
@Data
public class DriverInfoDownloadPassengerItemsVo {

    /**
     * 乘客称谓
     */
    private int passengerCaller;

    /**
     * 乘客手机号
     */
    private int callerPhone;

}
