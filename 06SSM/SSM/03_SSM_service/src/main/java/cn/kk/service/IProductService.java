package cn.kk.service;

import cn.kk.domain.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll() throws Exception;

    void saveOne(Product product) throws Exception;
}
