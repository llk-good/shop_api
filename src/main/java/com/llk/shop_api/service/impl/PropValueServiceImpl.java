package com.llk.shop_api.service.impl;

import com.llk.shop_api.dao.PropValueDao;
import com.llk.shop_api.model.po.PropValue;
import com.llk.shop_api.service.PropValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PropValueServiceImpl implements PropValueService {

    @Resource
    private PropValueDao propValueDao;


    @Override
    public List<PropValue> getDataByPid(Integer propid) {
        return propValueDao.getDataByPid(propid);
    }

    @Override
    public void add(PropValue prop) {
        propValueDao.add(prop);
    }
}
