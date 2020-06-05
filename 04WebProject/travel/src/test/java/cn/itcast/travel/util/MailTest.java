package cn.itcast.travel.util;

import org.junit.Test;

public class MailTest {
    @Test
    public void mailTest(){
        MailUtils.sendMail("itcast_xian@163.com","你好，这是一封测试邮件，无需回复。","测试邮件");
        System.out.println("发送成功");
    }
}
