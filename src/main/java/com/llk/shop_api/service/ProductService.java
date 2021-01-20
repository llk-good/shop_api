package com.llk.shop_api.service;

import com.llk.shop_api.model.po.Product;

import java.util.List;

public interface ProductService {
    List<Product> queryProd();

    void addProd(Product product);
}
