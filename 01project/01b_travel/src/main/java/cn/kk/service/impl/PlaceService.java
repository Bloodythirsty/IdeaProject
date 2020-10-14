package cn.kk.service.impl;

import cn.kk.dao.PlaceDao;
import cn.kk.pojo.Place;
import cn.kk.service.IPlaceService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService implements IPlaceService {

    @Autowired
    PlaceDao placeDao;

    @Override
    public List<Place> findPlaceByProvinceId(Integer page,Integer pageSize,Integer provinceId) throws Exception {
        PageHelper.startPage(page,pageSize);
        return placeDao.findPlaceByProvinceId(provinceId);
    }

    @Override
    public void savePlace(Place place) throws Exception {
        //先查询是否存在
        String name = placeDao.findPlaceByName(place.getName());
        if (!StringUtils.isBlank(name)){
            throw new RuntimeException("此景点已经存在！");
        }else {
            placeDao.savePlace(place);
        }
    }
}
