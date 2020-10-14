package cn.kk.service;

import cn.kk.pojo.Province;

import java.util.List;

public interface IProvinceService {
    public List<Province> findAllProvince() throws Exception;
    public List<Province> findAllProvince(Integer page, Integer pageSize) throws Exception;
    public void saveProvince(Province province) throws Exception;
    public void deleteProvince(Integer id) throws Exception;
    public void updateProvince(Province province) throws Exception;

}
