package cn.kk.service;

import cn.kk.domain.Items;

public interface IItemsService {

    public Items findById(Integer id);

    public void transfer(Integer sourceId, Integer targetId);
}
