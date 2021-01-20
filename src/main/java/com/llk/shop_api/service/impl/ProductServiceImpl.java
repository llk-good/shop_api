package com.llk.shop_api.service.impl;

import com.llk.shop_api.dao.ProductDao;
import com.llk.shop_api.model.po.Product;
import com.llk.shop_api.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;


    @Override
    public List<Product> queryProd() {
        return null;
    }

    @Override
    public void addProd(Product product) {
        product.setCreateDate(new Date());
        product.setUpdateDate(new Date());

        productDao.addProd(product);
    }
}
