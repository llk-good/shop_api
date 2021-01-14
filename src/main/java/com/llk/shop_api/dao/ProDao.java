package com.llk.shop_api.dao;

import com.llk.shop_api.model.po.Property;
import com.llk.shop_api.model.vo.PropPamas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProDao {
    Long queryDataCount(PropPamas pamas);

    List<Property> queryDataAll(PropPamas pamas);

    void addProp(Property pro);

    void updateData(Property pro);

    @Select("select * from s_prop where id = #{id}")
    List<Property> selectDataById(Integer id);
}
