package pack.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangkangkang created on 2021/3/1 5:02 下午
 * 判断前端传递过来要查询的字段：0：不查询，1：查询
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverInfoDownloadCarItemsVo {

    /**
     * 车牌号
     */
    private int plateNo;

    /**
     * 车辆颜色
     */
    private int color;
}
