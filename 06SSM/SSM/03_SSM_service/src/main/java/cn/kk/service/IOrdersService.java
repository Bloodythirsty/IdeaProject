package cn.kk.service;

import cn.kk.domain.Orders;

import java.util.List;

public interface IOrdersService {
    public Orders findById(String ordersId) throws Exception;
    public List<Orders> findAll() throws Exception;
}
