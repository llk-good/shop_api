package com.llk.shop_api.dao;

import com.llk.shop_api.model.po.Type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TypeDao {

    @Select("select * from s_type")
    List<Type> queryData();

    @Select("select * from s_type where pid = #{pid}")
    List<Type> queryDataByPid(Integer pid);

    void addType(Type ty);

    @Select("select * from s_type where id = #{id}")
    List<Type> updateById(Integer id);

    @Update("update s_type set name=#{name},pid=#{pid},updateDate=#{updateDate},isDel=#{isDel} where id = #{id}")
    void updateType(Type type);
}
