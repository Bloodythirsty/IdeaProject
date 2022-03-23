package pack._2021testspring.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * Description:
 *
 * @Author: heisenzhang@tencent.com
 * @DateTime: 2022-03-17 4:10 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAndAnswerVo {

    @ExcelIgnore
    private Long questionId;

    @ExcelIgnore
    private Long memberId;

    @ExcelProperty(index = 0, value = {"问答下载表", "问题"})
    private String title;

    @ExcelProperty(index = 1, value = {"问答下载表", "答案"})
    private String answer;

    @ExcelIgnore
    private Integer status;

    @ExcelIgnore
    private Long versionId;

    @ExcelIgnore
    private Date createTime;

    @ExcelIgnore
    private Date updateTime;

    @ExcelIgnore
    private Date verifyTime;

    public boolean isEmptyAnswer(){
        return StringUtils.isBlank(this.title) || StringUtils.isBlank(this.answer);
    }
}
