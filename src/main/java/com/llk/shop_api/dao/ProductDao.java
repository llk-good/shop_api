package com.llk.shop_api.dao;

import com.llk.shop_api.model.po.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao {
    void addProd(Product product);
}
