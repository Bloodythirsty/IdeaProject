package cn.kk.dao;


import cn.kk.pojo.Province;

import java.util.List;

public interface ProvinceDao {

    public List<Province> findAllProvince() throws Exception;

    public void saveProvince(Province province) throws Exception;

    public void deleteProvince(Integer id) throws Exception;

    public void updateProvince(Province province) throws Exception;

}
