package cn.kk.service.impl;

import cn.kk.dao.IOrderDao;
import cn.kk.domain.Orders;
import cn.kk.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class IOrdersServiceImpl implements IOrdersService {

    @Resource(name = "IOrderDao")
    private IOrderDao orderDao;

    @Override
    public Orders findById(String ordersId) throws Exception {
        return orderDao.findById(ordersId);
    }

    @Override
    public List<Orders> findAll() throws Exception {
        return orderDao.findAll();
    }
}
