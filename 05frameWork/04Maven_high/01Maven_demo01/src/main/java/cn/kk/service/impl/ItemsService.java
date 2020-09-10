package cn.kk.service.impl;

import cn.kk.dao.IItemsDao;
import cn.kk.domain.Items;
import cn.kk.service.IItemsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("itemsService")
public class ItemsService implements IItemsService {

    @Resource(name = "itemsDao")
    private IItemsDao itemsDao;

    public Items findById(Integer id) {
        System.out.println("service_findById");
        return itemsDao.findById(id);
    }
}
