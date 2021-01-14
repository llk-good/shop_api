package com.llk.shop_api.service.impl;

import com.llk.shop_api.dao.TypeDao;
import com.llk.shop_api.model.po.Type;
import com.llk.shop_api.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeDao typeDao;


    @Override
    public List<Type> queryData() {
        List<Type> list = typeDao.queryData();
        return list;
    }

    @Override
    public List<Type> queryDataByPid(Integer pid) {
        return typeDao.queryDataByPid(pid);
    }

    @Override
    public int addType(Type ty) {
        ty.setCreateDate(new Date());
        ty.setUpdateDate(new Date());
        ty.setIsDel(0);
        typeDao.addType(ty);
        return ty.getId();
    }

    @Override
    public List<Type> updateById(Integer id) {
        return typeDao.updateById(id);
    }

    @Override
    public void updateType(Type type) {
        type.setUpdateDate(new Date());
        typeDao.updateType(type);
    }
}
