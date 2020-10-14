package cn.kk.service.impl;

import cn.kk.dao.ProvinceDao;
import cn.kk.pojo.Province;
import cn.kk.service.IProvinceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements IProvinceService {

    @Autowired
    private ProvinceDao provinceDao;


    @Override
    public List<Province> findAllProvince() throws Exception {
        return provinceDao.findAllProvince();
    }

    @Override
    public List<Province> findAllProvince(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return provinceDao.findAllProvince();
    }

    @Override
    public void saveProvince(Province province) throws Exception {
        provinceDao.saveProvince(province);
    }

    @Override
    public void deleteProvince(Integer id) throws Exception {
        provinceDao.deleteProvince(id);
    }

    @Override
    public void updateProvince(Province province) throws Exception {
        provinceDao.updateProvince(province);
    }


}
