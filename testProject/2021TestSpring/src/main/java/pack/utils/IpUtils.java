package pack.utils;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: baidongliang@sogou-inc.com
 * @Date: 2020/7/29 20:44
 */
public class IpUtils {

    private static final int REGION_ARRAY_LENGTH = 5;
    private static final int REGION_ARRAY_PROVINCE_INDEX = 2;
    private static final int REGION_ARRAY_CITY_INDEX = 3;
    private static String resource;
    private static DbSearcher searcher;
    private static Logger logger = LoggerFactory.getLogger(IpUtils.class);

    static {

//        DbConfig config = null;
//        try {
//            resource = IpUtils.class.getResource("/ip2region/ip2region.db").getPath();
//            File file = new File(resource);
//            config = new DbConfig();
//            searcher = new DbSearcher(config, resource);
//        } catch (Exception e) {
//            logger.error("ip2region init filed!", e);
//        }
    }

    public static String getRegionFromIp(String ip) {
        try {
            DbConfig config = null;
            resource = IpUtils.class.getResource("/ip2region.db").getPath();
            File file = new File(resource);
            config = new DbConfig();
            searcher = new DbSearcher(config, resource);
            DataBlock dataBlock = searcher.btreeSearch(ip);
            if (Objects.isNull(dataBlock)) {
                logger.error("dataBlock is null");
                return StringUtils.EMPTY;
            }
            String region = dataBlock.getRegion();
            if (StringUtils.isBlank(region)) {
                return StringUtils.EMPTY;
            }
            //返回"省-市"
            String[] regionArray = region.split("\\|");
            if (regionArray.length == REGION_ARRAY_LENGTH) {
                if ("0".equals(regionArray[REGION_ARRAY_PROVINCE_INDEX])) {
                    if ("0".equals(regionArray[REGION_ARRAY_CITY_INDEX])) {
                        if ("0".equals(regionArray[0])) {
                            return "--";
                        }
                        return DataUtil.toUTF8(regionArray[0]);
                    } else {
                        return DataUtil.toUTF8(regionArray[REGION_ARRAY_CITY_INDEX]);
                    }
                }
                if ("0".equals(regionArray[REGION_ARRAY_CITY_INDEX])) {
                    return DataUtil.toUTF8(regionArray[REGION_ARRAY_PROVINCE_INDEX]);
                }
                return DataUtil.toUTF8(regionArray[REGION_ARRAY_PROVINCE_INDEX] + "-"
                        + regionArray[REGION_ARRAY_CITY_INDEX]);
            } else {
                return DataUtil.toUTF8(region);
            }
        } catch (Exception e) {
            logger.warn("getRegionFromIp failed! [ip]=" + ip, e);
            return StringUtils.EMPTY;
        }
    }

    public static String getClientIP(HttpServletRequest req) {
        String ip = req.getHeader("X-Real-IP");
        if (ip != null && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = req.getHeader("X-Forwarded-For");
        if (ip != null && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            return (index != -1) ? ip.substring(0, index) : ip;
        }
        ip = req.getHeader("Proxy-Client-IP");
        if (ip != null && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = req.getHeader("WL-Proxy-Client-IP");
        if (ip != null && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        } else {
            return req.getRemoteAddr();
        }
    }

    public static void main(String[] args) {
        List<String> collect = Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
        System.out.println(collect);
    }
}
