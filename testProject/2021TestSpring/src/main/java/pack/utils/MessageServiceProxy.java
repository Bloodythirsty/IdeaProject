package pack.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.joda.time.DateTime;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * tencent mail system
 */

@Slf4j
public class MessageServiceProxy {

    //x-rio-paasid：您的（调用者）应用的PaaSID
    private static final String X_PIO_PASSID="cvuzmxvdvylwfkbwlulwvtywlslxnlcnzpyugagvpcvuemhhbmc";

    //Token：创建应用时分配的加密密钥；(OA区和IDC内外区)
    private static final String TOKEN="ez0l5h63jM8MdLxVk5DVSjhBQXhNB1u4";

    //Token：创建应用时分配的加密密钥；（devnet区:测试分区 暂时不开放使用）
    //private static final String TOKEN="33333333333333333333333333";


    //    //邮件URL（IDC） 发送邮件消息（带附件）
//    private static final String MAIL_URL="https://idc.rio.tencent.com/ebus/tof4_msg/api/v1/Message/SendMail";


    //邮件URL（OA本地）发送邮件消息（带附件）
    private static final String MAIL_URL="http://rio.tencent.com/ebus/tof4_msg/api/v1/Message/SendMail";


    //邮件URL（IDC） 发送邮件消息（不带附件）
//    private static final String MAIL_URL="https://idc.rio.tencent.com/ebus/tof4_msg/api/v1/Message/SendMailInfo";


    //邮件URL（OA本地）发送邮件消息（不带附件）
//    private static final String MAIL_URL="http://rio.tencent.com/ebus/tof4_msg/api/v1/Message/SendMailInfo";



    //签名算法
    public static Map<String, String> getSignature(){

        //时间戳
        String timeStamp = DateUtils.getTimeStamp();
        //随机数
        String nonce = DateUtils.MakeSixNums();
        //x-rio-signature = sha256(x-rio-timestamp + Token + x-rio-nonce + x-rio-timestamp)
        String signature=timeStamp+TOKEN+nonce+timeStamp;

        String x_rio_signature = String2SHA256(signature);

        Map<String, String> headerInfo = new HashMap<>();
        headerInfo.put("x-rio-signature", x_rio_signature.toUpperCase());
        headerInfo.put("x-rio-paasid", X_PIO_PASSID);
        headerInfo.put("x-rio-timestamp", timeStamp.toString());
        headerInfo.put("x-rio-nonce", nonce);
        return headerInfo;
    }

    //sha256加密
    public static String String2SHA256(String str){
        MessageDigest messageDigest = null;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            log.error("catch NoSuchAlgorithmException e={}", e);
        } catch (UnsupportedEncodingException e) {
            log.error("catch UnsupportedEncodingException e={}", e);
        }
        return encdeStr;
    }

    public static void main(String[] args) {
        String s = null;
        try {
            s = MessageServiceProxy.SendMailInfo("heisenzhang@tencent.com", "939855685@qq.com", "test",
                    "test");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("s = " + s);
    }

    public static String SendMailInfo(String From,String To,String Titel,String Content) throws IOException {
//        From 发件人(邮箱格式) Y
//        To 收件人(邮箱格式),支持多人，按","分隔 Y
//        CC 抄送人(邮箱格式),支持多人，按","分隔 N
//        Bcc 密送人(邮箱格式),支持多人，按","分隔 N
//        Title 标题 Y
//        Content 内容 Y
//        EmailType 邮件类型（0 外部邮件 1内部邮件），默认1 N
//        BodyFormat 内容格式（0 文本 1 html格式），默认1 N
//        priority 优先级（-1:低 0:普通 1:高），默认0 N

        Map<String, String> signature = getSignature();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        /**
         * 普通邮件（不带附件）
         * content-type：application/json
         *
         *附件邮件（带附件）
         *content-type：multipart/form-data
         */
        headers.set("content-type", "multipart/form-data");
        headers.set("x-rio-paasid", signature.get("x-rio-paasid"));
        headers.set("x-rio-signature", signature.get("x-rio-signature"));
        headers.set("x-rio-timestamp", signature.get("x-rio-timestamp"));
        headers.set("x-rio-nonce", signature.get("x-rio-nonce"));

        //不带附件形式 用json
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("From", From);
//        jsonObject.put("To", To);
//        jsonObject.put("CC", "");
//        jsonObject.put("Bcc", "");
//        jsonObject.put("Title", Titel);
//        jsonObject.put("Content", Content);
//        jsonObject.put("EmailType", 1);
//        jsonObject.put("BodyFormat", 1);
//        jsonObject.put("priority", 0);

        //  带附件形式 用MultiValueMap
        MultiValueMap<String, Object> valueMap = new LinkedMultiValueMap<>();
        valueMap.add("From", From);
        valueMap.add("To", To);
        valueMap.add("CC", "");
        valueMap.add("Bcc", "");
        valueMap.add("Title", Titel);
        valueMap.add("Content", Content);
        valueMap.add("EmailType", "1");
        valueMap.add("BodyFormat", "1");
        valueMap.add("priority", "0");

        /**
         * 因为公司内部邮件服务 发送带内嵌图片的邮件
         * 内嵌图片文件名必须带前缀__INLINE__
         * 所以生成的图片文件名和读取文件名加上前缀
         * 在html的img标签中写：<img src="cid:__INLINE__line_chart.png">
         */
        String[] files= {"/Users/zhangkangkang/Documents/1.png"};
        for(String file : files) {
            //multipart/form-data方式上传文件
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            valueMap.add("files", fileSystemResource);
        }

        // post 带请求头
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(valueMap, headers);
        String s = restTemplate.postForObject(MAIL_URL, requestEntity, String.class);
        System.out.println(s);

        return s;

    }

}
