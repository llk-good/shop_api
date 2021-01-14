package com.llk.shop_api.dao;

import com.llk.shop_api.model.po.Brand;
import com.llk.shop_api.model.vo.BrandPamas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BrandDao {


    Long selectDataCount(BrandPamas pamas);

    List<Brand> getBrandData( BrandPamas pamas);

    void addBrand(Brand br);

    void updateBrand(Brand br);
}
