package pack._2021testspring.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @Author: heisenzhang@tencent.com
 * @DateTime: 2022-03-21 5:50 PM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadResultDto {
    private Integer successCount;
    private Integer failCount;
}
