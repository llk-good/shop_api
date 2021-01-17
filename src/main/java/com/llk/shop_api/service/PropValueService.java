package com.llk.shop_api.service;

import com.llk.shop_api.model.po.PropValue;

import java.util.List;

public interface PropValueService {
    List<PropValue> getDataByPid(Integer propid);

    void add(PropValue prop);

    void update(PropValue prop);
}
