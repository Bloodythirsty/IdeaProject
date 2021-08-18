package pack._2021testspring.bean;

import lombok.Data;

@Data
public class BaseReq {

    private int pageNum = 1;

    private int pageSize = 10;

    /**
     * 排序类别 1 正序 2 倒序 默认倒序
     */
    private int timeSortType = 2;

}
