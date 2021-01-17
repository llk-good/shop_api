package com.llk.shop_api.dao;

import com.llk.shop_api.model.po.PropValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PropValueDao {
    @Select("select * from s_propvalue where propid = #{propid}")
    List<PropValue> getDataByPid(Integer propid);

    @Insert("insert into s_propvalue (name,nameCH,propId) value (#{name},#{nameCH},#{propId})")
    void add(PropValue prop);
}
