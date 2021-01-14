package com.llk.shop_api.service.impl;

import com.llk.shop_api.dao.ProDao;
import com.llk.shop_api.model.po.Property;
import com.llk.shop_api.model.vo.PropPamas;
import com.llk.shop_api.service.ProService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProServiceImpl implements ProService {

    @Resource
    private ProDao proDao;


    @Override
    public Map getAllData(PropPamas pamas) {
        Map map = new HashMap();
        Long count = proDao.queryDataCount(pamas);
        map.put("count",count);

        List<Property> list = proDao.queryDataAll(pamas);
        map.put("list",list);
        return map;
    }

    @Override
    public void addProp(Property pro) {
        pro.setCreateDate(new Date());
        pro.setUpdateDate(new Date());
        pro.setAuthor("test");
        proDao.addProp(pro);
    }

    @Override
    public void updateData(Property pro) {
        pro.setUpdateDate(new Date());
        proDao.updateData(pro);
    }

    @Override
    public List<Property> selectDataById(Integer id) {
        return proDao.selectDataById(id);
    }
}
