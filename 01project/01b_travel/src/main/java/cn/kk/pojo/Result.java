package cn.kk.pojo;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Result {

    private Boolean state;
    private String msg;
    private Integer userId;
    private PageInfo<Province> provincePageInfo;
    private PageInfo<Place> placePageInfo;
}
