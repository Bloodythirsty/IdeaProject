package cn.kk.interceptor;

import cn.kk.utils.JWTUtils;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JWTinterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中的token（一般要求放在请求头中）
        String token = request.getHeader("token");
        Map<String, Object> map = new HashMap<>();
        try {
            JWTUtils.verifyToken(token);
            // map.put("msg", "验证通过~~~");
            // map.put("state", true);
            //直接放行即可，无需map
            return true;
        } catch (TokenExpiredException e) {
            // map.put("state", false);
            map.put("msg", "Token已经过期!!!");
        } catch (SignatureVerificationException e){
            // map.put("state", false);
            map.put("msg", "签名错误!!!");
        } catch (AlgorithmMismatchException e){
            // map.put("state", false);
            map.put("msg", "加密算法不匹配!!!");
        } catch (Exception e) {
            e.printStackTrace();
            // map.put("state", false);
            map.put("msg", "无效token~~");
        }
        map.put("state", false);
        //将map转为json，传到前台
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(), map);
        return false;
    }
}
