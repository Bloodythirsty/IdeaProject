package cn.kk;

import cn.kk.dao.UserDao;
import cn.kk.poji.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Base64Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testJWT(){

        //设置过期时间
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE,30);   //当前时间+30
        Date date = instance.getTime();             //获取Date

        Map<String,Object> map = new HashMap<>();
        String token = JWT.create()
                .withHeader(map)        //header
                .withClaim("userId", 123)   //payload
                .withClaim("username", "张三")
                // .withExpiresAt(date)
                .sign(Algorithm.HMAC256("@#ss#$"));//签名

        System.out.println("token = " + token);
        /*
        eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.
        eyJleHAiOjE2MDI0MTg4ODAsInVzZXJJZCI6MTIzLCJ1c2VybmFtZSI6IuW8oOS4iSJ9.
        IyAMF_hKGICcMx1u-n8BNLEQknvOv0cUYNUQd2qyuMs
         */

    }

    @Test
    void testBase64() {
        byte[] bytes = Base64Utils.decodeFromString("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9");
        String s = new String(bytes);
        System.out.println("s = " + s);

        byte[] bytes1 = Base64Utils.decodeFromString("eyJleHAiOjE2MDI0MTg4ODAsInVzZXJJZCI6MTIzLCJ1c2VybmFtZSI6IuW8oOS4iSJ9");
        String s1 = new String(bytes1);
        System.out.println("s1 = " + s1);
    }


    @Test
    void test() {
        Verification verification = JWT.require(Algorithm.HMAC256("@#ss#$"));
        //验证对象
        JWTVerifier build = verification.build();
        //验证
        DecodedJWT verify = build.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEyMywidXNlcm5hbWUiOiLlvKDkuIkifQ.MqGFnR1JC-lWALQPBn6EiRigDqMWlaNGFU65uqEruqo");
        //获取值
        System.out.println("verify.getHeader() = " + verify.getHeader());
        System.out.println("verify.getPayload() = " + verify.getPayload());
        System.out.println("verify.getSignature() = " + verify.getSignature());
        System.out.println("verify.getToken() = " + verify.getToken());

        System.out.println("verify.getClaim(\"userId\") = " + verify.getClaim("userId"));
        System.out.println("verify.getClaim(\"userName\") = " + verify.getClaim("username"));


        System.out.println("verify.getClaim(\"userId\").asString() = " + verify.getClaim("userId").asInt());
        System.out.println("verify.getClaim(\"username\").asString() = " + verify.getClaim("username").asString());

        System.out.println("verify.getExpiresAt() = " + verify.getExpiresAt());
    }

    @Autowired
    UserDao userDao;

    @Test
    void testDao() {
        User kkk = userDao.findByUsername("kkk");
        System.out.println("kkk = " + kkk);
    }
}
