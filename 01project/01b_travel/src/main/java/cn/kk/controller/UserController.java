package cn.kk.controller;

import cn.kk.pojo.Result;
import cn.kk.pojo.User;
import cn.kk.service.IUserService;
import cn.kk.utils.UUIDutils;
import cn.kk.utils.VerifyCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin    //允许跨域
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    /*
            因为是不同的会话，所以不能直接存入session，存入Context全局域
     */
    @GetMapping("getVerifyCode")
    public Map<String, String> getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // //响应浏览器
        // VerifyCode.noCache(response);
        //
        // //生成验证码：
        // String securityCode = VerifyCode.getCheckCode();
        // //存入session
        // session.setAttribute("verifyCode", securityCode);
        // //生成图片
        // BufferedImage image = VerifyCode.getImage(securityCode);
        //
        // response.setContentType("image/png");
        // ImageIO.write(image, "png",response.getOutputStream());

        //响应浏览器
        VerifyCode.noCache(response);

        //生成验证码：
        String securityCode = VerifyCode.getCheckCode();
        //生成验证码时间戳key
        String key = UUIDutils.getLowerUUID();
        //验证码存入context
        request.getServletContext().setAttribute(key, securityCode);

        //生成图片
        BufferedImage image = VerifyCode.getImage(securityCode);
        // 图片编码
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        String imageString = Base64Utils.encodeToString(baos.toByteArray());

        //放进map，返回前端
        Map<String, String> map = new HashMap<>();
        map.put("key", key);             //把验证码的时间戳放进map，传到前台，前台再把key值传到后台，后台根据key，去取Context里面的属性
        map.put("image", imageString);
        //ImageIO.write(image, "png",response.getOutputStream());

        return map;
    }

    @PostMapping("register")
    public Result register(String code, String key, @RequestBody User user, HttpServletRequest request) {
        log.info("前台接收得验证码：" + code);
        log.info("接收得对象：" + user);
        log.info("接收到验证码的key=" + key);

        //验证验证码(在注册页面得时候，显示了图片，访问了 user/getVerifyCode，即已经将验证码存入session)
        String verifyCode = (String) request.getServletContext().getAttribute(key);
        request.getServletContext().removeAttribute(key);
        log.info("从Context里面拿到的code=" + verifyCode);
        Result result = new Result();
        try {
            if (verifyCode.equalsIgnoreCase(code)) {        //此处字符串可能为空
                //注册用户
                userService.saveUser(user);                 //dao可能异常
                result.setState(true).setMsg("注册成功！");
            } else {
                result.setState(false).setMsg("验证码错误！刷新页面后重试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());      //此处可以把异常信息写入结果
        }
        return result;
    }

    @PostMapping("login")
    public Result login(String code, String key, @RequestBody User user, HttpServletRequest request) {
        log.info("登陆~~~");
        log.info("前台接收得验证码：" + code);
        log.info("接收得对象：" + user);
        log.info("接收到验证码的key=" + key);

        String verifyCode = (String)request.getServletContext().getAttribute(key);
        log.info("后台的验证码="+verifyCode);
        //验证码失效
        request.getServletContext().removeAttribute(key);
        Result result = new Result();
        try {
            if (code.equalsIgnoreCase(verifyCode)){
                User byUsername = userService.login(user);
                /*
                        保存用户登陆标记setUserId
                 */
                result.setUserId(byUsername.getId()).setState(true).setMsg("登陆成功！");
                /*
                        用户信息存入 application域
                 */
                request.getServletContext().setAttribute(byUsername.getId().toString(),byUsername);
            }else {
                result.setState(false).setMsg("验证码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }
}
