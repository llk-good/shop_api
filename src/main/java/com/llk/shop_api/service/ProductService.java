package com.llk.shop_api.service;

import com.llk.shop_api.model.po.Product;
import com.llk.shop_api.model.vo.ProdPamas;

import java.util.Map;

public interface ProductService {
    Map queryProd(ProdPamas pamas);

    void addProd(Product product);
}
