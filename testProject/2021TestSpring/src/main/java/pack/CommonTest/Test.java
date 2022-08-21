package pack.CommonTest;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import pack.bean.FileUploadResultDto;

/**
 * Description:
 *
 * @Author: heisenzhang@tencent.com
 * @DateTime: 2022-03-28 2:29 PM
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<FileUploadResultDto> dtos = Lists.newArrayList(new FileUploadResultDto(1, 1),
                new FileUploadResultDto(2, 2));
        Iterator<FileUploadResultDto> iterator = dtos.iterator();
        while (iterator.hasNext()) {
            FileUploadResultDto next = iterator.next();
            if (next.getSuccessCount() == 2) {
                next.setSuccessCount(5);
            }
            if (next.getSuccessCount() == 1) {
                iterator.remove();
            }
        }
        System.out.println(dtos);
    }

}
