package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换，因为只有HttpServletRequest才能获取路径
        HttpServletRequest request = (HttpServletRequest)req;

        //1. 获取请求资源的请求路径
        String requestURI = request.getRequestURI();
        //2. 判断是否包含登录相关资源路径
        if ( requestURI.contains("/login.jsp") || requestURI.contains("/loginServlet")  || requestURI.contains("/checkCodeServlet") || requestURI.contains("/css/") || requestURI.contains("/js/") || requestURI.contains("/fonts/")){
            //证明用户就是想去登录，则放行
            chain.doFilter(req, resp);
        }else {
            // 不是去登录，而是访问资源
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                //已经登录，放行
                chain.doFilter(req, resp);
            }else{
                //未登录，则提示登录
                request.setAttribute("login_err_msg","请先登录");
                request.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
