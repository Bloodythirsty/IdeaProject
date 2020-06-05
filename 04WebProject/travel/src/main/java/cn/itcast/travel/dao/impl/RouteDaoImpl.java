package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteDaoImpl implements RouteDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid, String rname) {
        /*
            1. 现在不仅负责全部列表展示，而且要考虑到查询，所以用模板
            2. 从首页index直接查询，没有cid，即cid=0，所以要去判断
         */
        //String sql = "select count(*) from tab_route where cid = ? and rname like '%兵马俑%' “;
        String sql = " select count(*) from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List list = new ArrayList();            //需要给sql传递的参数
        if (cid != 0){
            sb.append(" and cid = ? ");
            list.add(cid);
        }
        if (rname != null && rname.length() > 0){
            sb.append(" and rname like ? ");
            list.add("%"+rname+"%");
        }
        sql = sb.toString();
        return template.queryForObject(sql,Integer.class,list.toArray());
    }

    @Override
    public List<Route> findByPage(int cid, int start, int size, String rname) {
        //select * from tab_route where cid = 5 and rname LIKE '%兵马俑%' limit 1 , 10
        String sql = " select * from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List list = new ArrayList();            //需要给sql传递的参数
        if (cid != 0){
            sb.append(" and cid = ? ");
            list.add(cid);
        }
        if (rname != null && rname.length() > 0){
            sb.append(" and rname like ? ");
            list.add("%"+rname+"%");
        }
        sb.append(" limit ? , ? "); //分页条件
        list.add(start);
        list.add(size);

        sql = sb.toString();
        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),list.toArray());
    }

    @Override
    public Route findOneRoute(String rid) {
        String sql = " select * from tab_route where rid = ? ";
        try {
            Route route = template.queryForObject(sql,new BeanPropertyRowMapper<>(Route.class),rid);
            return route;
        }catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<RouteImg> findImgByRid(String rid) {
        String sql = " select * from tab_route_img where rid = ? ";
        return template.query(sql, new BeanPropertyRowMapper<>(RouteImg.class),rid);


    }

    @Override
    public Seller findSeller(int sid) {
        String sql = " select * from tab_seller where sid = ? ";
        try {
            Seller seller = (Seller) template.queryForObject(sql,new BeanPropertyRowMapper<>(Seller.class),sid);
            return seller;
        }catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Category findCatogry(int cid) {
        String sql = " select * from tab_category where cid = ? ";
        try {
            Category category = (Category) template.queryForObject(sql,new BeanPropertyRowMapper<>(Category.class),cid);
            return category;
        }catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean findFavourite(String rid, int uid) {
        String sql = " select count(*) from tab_favorite where rid = ? and uid = ? ";
        Integer integer = template.queryForObject(sql, Integer.class, rid, uid);
        return integer != 0;
    }

    @Override
    public int favoriteRouteCount(String rid) {
        String sql = " select count(*) from tab_favorite where rid = ? ";
        return template.queryForObject(sql,Integer.class,rid);
    }

    @Override
    public void addFavorite(String rid, int uid) {
        String sql = "insert into tab_favorite(rid,date,uid) values(?,?,?)";
        template.update(sql,
                rid,new SimpleDateFormat("yyyy-MM-dd").format(new Date()),uid);
    }
}
