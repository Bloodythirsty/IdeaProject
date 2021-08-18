package pack._2021testspring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangkangkang created on 2021/3/1 5:03 下午
 * 判断前端传递过来要查询的字段：0：不查询，1：查询
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverInfoDownloadAllItemsVo {

    private DriverInfoDownloadDriverItemsVo driverItems;

    private DriverInfoDownloadCarItemsVo carItems;

    private DriverInfoDownloadPassengerItemsVo passengerItems;

    private DriverInfoDownloadOrderItemsVo orderItems;

}
