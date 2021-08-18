package testZip4j;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.apache.commons.lang3.ObjectUtils;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * @author zhangkangkang created on 2021/3/11 1:01 上午
 */
public class TestZip4j {

    @Test
    public void testZip1() throws IOException, ZipException {
        ZipFile zipFile = new ZipFile("/Users/didi/Documents/didi-workspace/project_04_司机明细下载/司机明细信息下载示例2.zip", "1234".toCharArray());
        ZipParameters parameters = new ZipParameters();
        //压缩方式
        parameters.setCompressionMethod(CompressionMethod.DEFLATE);
        // 压缩级别
        parameters.setCompressionLevel(CompressionLevel.NORMAL);
        parameters.setEncryptFiles(true);
        parameters.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);

//        zipFile.addFile(,parameters);
//        zipFile.addFile(new File("/Users/didi/Documents/didi-workspace/project_04_司机明细下载/设计.sql"),parameters);
        List<File> files = Lists.newArrayList();
        files.add(new File("/Users/didi/Documents/didi-workspace/project_04_司机明细下载/司机明细信息下载示例.csv"));
        for (File file : files) {
            zipFile.addFile(file, parameters);
        }
    }

    @Test
    public void name() {
        File file = new File("/Users/didi/Documents/didi-workspace/project_04_司机明细下载/司机明细信息下载示例.csv");
        if (file.exists()){
            file.deleteOnExit();
        }
    }

    @Test
    public void testSting() {
        String s = "司机明细信息下载示例2.cvs";
        String substring = s.substring(0, s.lastIndexOf("."));
        System.out.println("substring = " + substring);
        String s1 = substring + ".zip";
        System.out.println("s1 = " + s1);
        System.out.println(UUID.randomUUID().toString().substring(0, 5));
        System.out.println(UUID.randomUUID().toString().substring(0, 5));
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        System.out.println(UUID.randomUUID().toString().length());
    }

    @Test
    public void testString1() {
        String emailTemplate = "#{operatorName}，您好<br/>" +
                "<br/>" +
                "#{operateTime}，您提交了【#{cityName}-#{channelName}-#{pushType}】的司机信息下载，zip 压缩包的密码为 #{password}。<br/>" +
                "<br/>" +
                "因数据量较大，结果共包括#{filesNum}个附件，拆分为#{emailNum}封邮件，请注意查收。<br/>" +
                "<br/>" +
                "如有任何疑问，请反馈至D-chat【GA管理平台-用户反馈群】";

        Map<String, String> item = Maps.newHashMap();
        item.put("operatorName", "1");
        item.put("operateTime", new DateTime().toString("yyyy-MM-dd HH:mm"));
        item.put("cityName", "北京");
        item.put("channelName", "jtb");
        item.put("pushType", "全量");
        item.put("password", "zzzzs");
        item.put("filesNum", "2");
        item.put("emailNum", "2");
        for (Map.Entry<String, String> entry : item.entrySet()) {
            String replace = "#\\{" + entry.getKey() + "}";
            emailTemplate = emailTemplate.replaceAll(replace, entry.getValue());
        }

    }

    @Test
    public void testNuk() {
        long sumBytes = 0;
        List<Integer> integerList = Lists.newArrayList(1, 2, 3, 5, 3, 2, 1, 1);
        List<List<Integer>> result = Lists.newArrayList();
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < integerList.size(); i++) {
            list.add(integerList.get(i));
            sumBytes += integerList.get(i);
            if (sumBytes > 5 && list.size() > 1) {
                Integer remove = list.remove(list.size() - 1);
                result.add(list);
                sumBytes = integerList.get(i);
                list = Lists.newArrayList(remove);
            } else if (sumBytes > 5 && list.size() == 1) {
                result.add(list);
                sumBytes = 0;
                list = Lists.newArrayList();
            }
        }
        result.add(list);
    }

    @Test
    public void testString() {
        String path ="/Users/didi/Documents/didi-workspace/project_04_司机明细下载/司机明细信息下载示例.csv";
        String substring = path.substring(path.lastIndexOf("/") + 1);

        System.out.println("substring = " + substring);
    }
}
