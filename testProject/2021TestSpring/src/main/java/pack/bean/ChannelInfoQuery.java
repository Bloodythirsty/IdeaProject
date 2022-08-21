package pack.bean;

import lombok.Data;

/**
 * @author wusong
 */

@Data
public class ChannelInfoQuery extends BaseReq{

    private String cityId;

    private String channelCode;

    private String state;

}
