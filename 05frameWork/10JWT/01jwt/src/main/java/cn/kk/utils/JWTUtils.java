package cn.kk.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JWTUtils {

    private static final String SECRET = "!VFGT^%$Y565##@";

    /*
          生成token
     */
    public static String getToken(Map<String, String> map) {
        //默认七天
        return getToken(map, 7);
    }

    public static String getToken(Map<String, String> map, Integer day) {
        JWTCreator.Builder builder = JWT.create();
        //遍历map的lambda表达式
        map.forEach(builder::withClaim);  //payload

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        Date date = calendar.getTime();
        builder.withExpiresAt(date);

        String token = builder.sign(Algorithm.HMAC256(SECRET));//signature
        return token;
    }

    /*
            验证token并返回DecodeJWT：，因为有任何异常都会抛出
     */
    public static DecodedJWT verifyToken(String token){
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    }

    // /*
    // \   获取信息
    //  */
    // public static DecodedJWT getDecodeJWT(String token){
    //     return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    // }
}
