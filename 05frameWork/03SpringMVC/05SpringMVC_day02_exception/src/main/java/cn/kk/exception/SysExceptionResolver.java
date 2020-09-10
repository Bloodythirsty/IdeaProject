package cn.kk.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
        异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //1. 获取到异常
        SysException ex = null;
        if (e instanceof SysException){     //是自定义的异常
            ex = (SysException)e;
        }else {                             //不是自定义异常
            ex = new SysException("系统正在维护");
        }
        //2. 创建modelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg",e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
