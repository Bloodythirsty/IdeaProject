package cn.kk.service.impl;

import cn.kk.dao.IProductDao;
import cn.kk.domain.Product;
import cn.kk.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void saveOne(Product product) throws Exception {
        productDao.saveOne(product);
    }
}
