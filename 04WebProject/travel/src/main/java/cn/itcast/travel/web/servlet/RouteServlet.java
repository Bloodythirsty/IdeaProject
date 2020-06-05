package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import com.sun.org.apache.bcel.internal.generic.IFNULL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {


    RouteService routeService = new RouteServiceImpl();

    protected void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        String rname = request.getParameter("rname");   //模糊查询 , 此处获得的乱码，需要处理
        if ("null".equals(rname)) {
            rname = null;
        }
        if (rname != null && rname.length() > 0) {
            rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        }


        //2. 处理参数
        int cid = 0;
        if ("null".equals(cidStr)) {
            cid = 5;
        }
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }

        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;       //默认显示5条
        }

        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;       //默认当前第一页
        }

        //3. 调用service
        PageBean<Route> routePageBean = routeService.pageQuery(cid, currentPage, pageSize, rname);

        //4. 将pageBean序列化
        toJson(response, routePageBean);


    }

    /*
            根据rid查询一个route
     */
    protected void findOneRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接受rid：路线id
        String rid = request.getParameter("rid");
        //2. 查询
        Route route = routeService.findOneRoute(rid);
        //3. 序列化
        toJson(response, route);
    }

    // 判断登陆用户是否收藏
    protected void isFavouriteRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取rid
        String rid = request.getParameter("rid");
        //2. 获取当前user
        User user = (User) request.getSession().getAttribute("user");
        Boolean exist = false;
        //3. 查询
        if (user != null) {
            exist = routeService.findFavourite(rid, user.getUid());
        }
        //4. 写回客户端
        toJson(response, exist);
    }

    /*
            计算收藏次数
     */
    protected void favoriteRouteCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        int count = routeService.favoriteRouteCount(rid);
        toJson(response, count);
    }

    /*
            点击收藏后，添加
     */
    protected void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        int uid = 0;
        if (user == null){
            return ;
        }else {
            uid = user.getUid();
        }

        routeService.addFavorite(rid,uid);

    }
}