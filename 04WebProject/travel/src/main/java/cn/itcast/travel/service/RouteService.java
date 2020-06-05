package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface RouteService {

    PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    Route findOneRoute(String rid);

    Boolean findFavourite(String rid, int uid);

    int favoriteRouteCount(String rid);

    void addFavorite(String rid, int uid);
}
