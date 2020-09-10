package ServletAndRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-19;
 */
/*   获取请求行数据
                1. 获取请求方式`GET`：
					- `String getMethod()`
				2. 获取虚拟目录`/day14`	：
					- `String getContextPath()` 即application context中的内容
				3. 获取呼叫servlet的资源的路径`/demo04.do`：
					- `String getServletPath()  `
				4. 获取`GET`方式请求参数：
					- `String getQueryString() `
				5. 获取完整`URI:/day14/demo04.do`：
					- `String getRequestURI()  `
				6. 获取`Http://localhost/day14/demo04.do`:
					- `StringBuffer getRequestURL()`
				7. 获取http协议及其版本号`HTTP/1.1`：
					- `String getProtocol()  ` ServletRequest里面
				8. 获取客户机IP：
					- `String getRemoteAddr()`
 */
@WebServlet("/requestDemo01")
public class Demo01_getRequestLine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        1. 获取请求方式`GET`：
        System.out.println("1." + req.getMethod());
//        2. 获取虚拟目录`/day14`	：
        System.out.println("2." + req.getContextPath());
//        3. 获取呼叫servlet的资源的路径`/demo04.do`：
        System.out.println("3." + req.getServletPath());
//        4. 获取`GET`方式请求参数：            url后面跟  ？参数  即可显示
        System.out.println("4." + req.getQueryString());
//        5. 获取完整`URI:/day14/demo04.do`：
        System.out.println("5." + req.getRequestURI());
//        6. 获取`Http://localhost/day14/demo04.do`:
        System.out.println("6." + req.getRequestURL());
//        7. 获取http协议及其版本号`HTTP/1.1`：
        System.out.println("7." + req.getProtocol());
//        8. 获取客户机IP：
        System.out.println("8." + req.getRemoteAddr());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
