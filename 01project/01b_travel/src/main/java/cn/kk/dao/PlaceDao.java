package cn.kk.dao;

import cn.kk.pojo.Place;

import java.util.List;

public interface PlaceDao {
    public List<Place> findPlaceByProvinceId(Integer provinceId) throws Exception;
    public String findPlaceByName(String name) throws Exception;
    public void savePlace(Place place) throws Exception;
    public void updatePlace(Place place) throws Exception;
}
