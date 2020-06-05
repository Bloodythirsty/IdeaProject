package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    RouteDao routeDao = new RouteDaoImpl();

    /*
        正常category查询
     */
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
//1. 封装pageBean
        PageBean<Route> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        //根据cid，找到cid对应的旅游路线的总数
        int totalCount = routeDao.findTotalCount(cid,rname);
        pb.setTotalCount(totalCount);
        //分页查询
        int start = (currentPage-1)*pageSize;
        List<Route> list = routeDao.findByPage(cid,start,pageSize,rname);
        pb.setList(list);
        //设置总页数
        int totalPage = totalCount % pageSize == 0 ? totalCount/pageSize : totalCount/pageSize+1;
        pb.setTotalPage(totalPage);


        return pb;
    }

    @Override
    public Route findOneRoute(String rid) {
        //1. 查询基本route
        Route route = routeDao.findOneRoute(rid);
        //2. 根基rid查询route_img的信息(集合)
        List<RouteImg> list_img = routeDao.findImgByRid(rid);
        route.setRouteImgList(list_img);
        //3. 根据route里面的sid查出route_seller里面的信息（一条）
        Seller seller = routeDao.findSeller(route.getSid());
        route.setSeller(seller);
        //4. 根据cid，从category表查询cname
        Category category = routeDao.findCatogry(route.getCid());
        route.setCategory(category);

        return route;


    }

    @Override
    public Boolean findFavourite(String rid, int uid) {
        return routeDao.findFavourite(rid,uid);
    }

    @Override
    public int favoriteRouteCount(String rid) {
        return routeDao.favoriteRouteCount(rid);
    }

    @Override
    public void addFavorite(String rid, int uid) {
        routeDao.addFavorite(rid,uid);
    }
}
