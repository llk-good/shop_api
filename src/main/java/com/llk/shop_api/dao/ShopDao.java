package com.llk.shop_api.dao;

import com.llk.shop_api.model.po.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopDao {

    @Select("select * from s_brand")
    public List<Brand> queryBrandData();
}
