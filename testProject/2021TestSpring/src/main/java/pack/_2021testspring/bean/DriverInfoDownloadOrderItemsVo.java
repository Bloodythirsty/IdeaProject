package pack._2021testspring.bean;

import lombok.Data;

/**
 * @author zhangkangkang created on 2021/3/1 5:03 下午
 * 判断前端传递过来要查询的字段：0：不查询，1：查询
 */
@Data
public class DriverInfoDownloadOrderItemsVo {
    /**
     * 订单编号
     */
    private int orderId;

    /**
     * 呼叫日期
     */
    private int dt;

    /**
     * 订单创建时间
     */
    private int birthTime;

    /**
     * 订单取消时间：乘客，司机取消时间三选一
     */
    private int orderCancelledTime;

    /**
     * 订单应答时间:接单时间
     */
    private int strivedTime;

    /**
     * 司机到达时间
     */
    private int arrivedTime;

    /**
     * 开始计费时间
     */
    private int beginChargeTime;

    /**
     * 结束计费时间: 完单时间
     */
    private int finishedTime;

    /**
     * 乘客上车点名称 ： supervision.dwd_netcar_order_detail_df 全量表取不到
     */
    private int startingName;

    /**
     * 乘客上车点经度
     */
    private int startingLng;

    /**
     * 乘客上车点纬度
     */
    private int startingLat;

    /**
     * 乘客下车点名称 ： supervision.dwd_netcar_order_detail_df 全量表取不到
     */
    private int destName;

    /**
     * 乘客下车点经度
     */
    private int destLng;

    /**
     * 乘客下车点纬度
     */
    private int destLat;

    /**
     * 订单金额：乘客应付
     */
    private int pTotalFee;

    /**
     * 司机实际收取: 取不到
     */
    private int driverRealFee;

    /**
     * 优惠金额：取不到
     */
    private int discountFee;

}
