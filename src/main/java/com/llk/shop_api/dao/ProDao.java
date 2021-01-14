package com.llk.shop_api.dao;

import com.llk.shop_api.model.po.Property;
import com.llk.shop_api.model.vo.PropPamas;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProDao {
    Long queryDataCount(PropPamas pamas);

    List<Property> queryDataAll(PropPamas pamas);

    void addProp(Property pro);

    void updateData(Property pro);
}
