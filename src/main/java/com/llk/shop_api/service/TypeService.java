package com.llk.shop_api.service;

import com.llk.shop_api.model.po.Type;

import java.util.List;

public interface TypeService {
    List<Type> queryData();

    List<Type> queryDataByPid(Integer pid);

    int addType(Type ty);

    List<Type> updateById(Integer id);

    void updateType(Type type);
}
