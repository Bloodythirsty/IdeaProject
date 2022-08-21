package pack.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.lang3.StringUtils;

/**
 * 数据工具类
 *
 * @author wangjiaqi
 * @date 2021/12/23
 **/
public class DataUtil {

    /**
     * 将字符串的编码格式转换为utf-8
     *
     * @param str
     */
    public static String toUTF8(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        Charset charset;
        if (str.equals(new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8))) {
            charset = StandardCharsets.UTF_8;
        } else if (str.equals(new String(str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.ISO_8859_1))) {
            charset = StandardCharsets.ISO_8859_1;
        } else if (str.equals(new String(str.getBytes(StandardCharsets.UTF_16), StandardCharsets.UTF_16))) {
            charset = StandardCharsets.UTF_16;
        } else if (str.equals(new String(str.getBytes(StandardCharsets.US_ASCII), StandardCharsets.US_ASCII))) {
            charset = StandardCharsets.US_ASCII;
        } else if (str.equals(new String(str.getBytes(StandardCharsets.UTF_16BE), StandardCharsets.UTF_16BE))) {
            charset = StandardCharsets.UTF_16BE;
        } else if (str.equals(new String(str.getBytes(StandardCharsets.UTF_16LE), StandardCharsets.UTF_16LE))) {
            charset = StandardCharsets.UTF_16LE;
        } else {
            charset = StandardCharsets.UTF_8;
        }
        return new String(str.getBytes(charset), StandardCharsets.UTF_8);
    }
}
