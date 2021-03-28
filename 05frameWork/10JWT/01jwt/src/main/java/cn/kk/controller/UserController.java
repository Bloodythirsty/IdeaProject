package cn.kk.controller;

import cn.kk.dao.UserDao;
import cn.kk.poji.User;
import cn.kk.service.IUserService;
import cn.kk.util.MyThradLocal;
import cn.kk.utils.JWTUtils;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("login")
    public Map<String, Object> login(User user) {
        log.info(user.toString());
        log.info("thread name:"+Thread.currentThread().getName());
        Map<String, Object> map = new HashMap<>();
        try {
            User userDB = userService.findByUsername(user.getUsername());

            Map<String,String> payload = new HashMap<>();
            payload.put("username",userDB.getUsername());
            payload.put("userId",userDB.getId());
            //生成token
            String token = JWTUtils.getToken(payload);
            //登陆后，把token放进Threadlocal
            MyThradLocal.setTokenFromThreadLoca(token);

            map.put("state", true);
            map.put("msg", "成功");
            map.put("token",token);     //相应token
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }


    /*
            测试利用token下面的接口
     */
    // @PostMapping
    // public Map<String, Object> testToken(String token) {
    //     log.info("当前token："+token);
    //     Map<String, Object> map = new HashMap<>();
    //     try{
    //         DecodedJWT decodedJWT = JWTUtils.verifyToken(token);
    //         //验证通过，处理业务
    //         log.info("username:"+decodedJWT.getClaim("username").asString());
    //     }catch (Exception e){
    //         e.printStackTrace();
    //         map.put("state", false);
    //         map.put("msg", e.getMessage());
    //     }
    //     return map;
    // }

    /*
            有了拦截器验证 token，只需要处理业务即可
     */
    @PostMapping
    public Map<String, Object> testToken(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("处理业务");

        /*
                若token里面存了有用信息，重新获取即可
         */
       // String token = request.getHeader("token");
        //从Threadlocal拿token
        log.info("thread name:"+Thread.currentThread().getName());
        String token = MyThradLocal.getTokenFromThreadLoca();
        log.info("token from ThreadLocal:"+token);
        DecodedJWT decodedJWT = JWTUtils.verifyToken(token);
        log.info(decodedJWT.getClaim("username").asString());

        map.put("msg", "成功");
        return map;
    }


}
