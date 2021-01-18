package com.llk.shop_api.dao;

import com.llk.shop_api.model.po.PropValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PropValueDao {
    @Select("select * from s_propvalue where propId = #{propid}")
    List<PropValue> getDataByPid(Integer propid);

    @Insert("insert into s_propvalue (name,nameCH,propId) value (#{name},#{nameCH},#{propId})")
    void add(PropValue prop);

    @Update("update s_propvalue set name = #{name},nameCH = #{nameCH},propId = #{propId},isDel=#{isDel} where id = #{id}")
    void update(PropValue prop);
}
