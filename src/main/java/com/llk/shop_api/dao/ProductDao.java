package com.llk.shop_api.dao;

import com.llk.shop_api.model.po.Product;
import com.llk.shop_api.model.vo.ProdPamas;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    void addProd(Product product);

    Long queryProdCount(ProdPamas pamas);

    List<Product> queryProdData(ProdPamas pamas);

    void upate(Product prod);
}
