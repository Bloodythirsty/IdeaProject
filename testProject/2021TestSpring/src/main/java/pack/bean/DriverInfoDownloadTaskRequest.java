package pack.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhangkangkang created on 2021/3/1 4:49 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverInfoDownloadTaskRequest {
    private String cityId;
    private String cityName;
    private String channelCode;
    private String channelName;
    private int pushType;
    private Date beginTime;
    private Date endTime;
    private int dataType;
    private String uploadFilePath;
    private String uploadImagePath;
    private DriverInfoDownloadAllItemsVo allItems;
}
