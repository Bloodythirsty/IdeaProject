package cn.kk.service;

import cn.kk.pojo.Place;

import java.util.List;

public interface IPlaceService {
    public List<Place> findPlaceByProvinceId(Integer page,Integer pageSize,Integer provinceId) throws Exception;

    public void savePlace(Place place) throws Exception;

}
