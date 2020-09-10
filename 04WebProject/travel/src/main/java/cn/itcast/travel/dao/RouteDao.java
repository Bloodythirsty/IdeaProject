package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;

import java.util.List;

public interface RouteDao {
    int findTotalCount(int cid, String rname);
    List<Route> findByPage(int cid, int start, int size, String rname);

    Route findOneRoute(String rid);

    List<RouteImg> findImgByRid(String rid);

    Seller findSeller(int sid);

    Category findCatogry(int cid);

    Boolean findFavourite(String rid, int uid);

    int favoriteRouteCount(String rid);

    void addFavorite(String rid, int uid);
}
