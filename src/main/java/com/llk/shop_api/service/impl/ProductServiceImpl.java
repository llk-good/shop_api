package com.llk.shop_api.service.impl;

import com.llk.shop_api.dao.ProductDao;
import com.llk.shop_api.model.po.Product;
import com.llk.shop_api.model.vo.ProdPamas;
import com.llk.shop_api.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;


    @Override
    public Map queryProd(ProdPamas pamas) {
        Map map = new HashMap();
        Long count = productDao.queryProdCount(pamas);
        map.put("count",count);

        List<Product> list = productDao.queryProdData(pamas);
        map.put("list",list);

        return map;
    }

    @Override
    public void addProd(Product product) {
        product.setCreateDate(new Date());
        product.setUpdateDate(new Date());

        productDao.addProd(product);
    }
}
