package com.llk.shop_api.service.impl;

import com.llk.shop_api.dao.ShopDao;
import com.llk.shop_api.model.po.Brand;
import com.llk.shop_api.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopDao shopDao;


    @Override
    public List<Brand> queryBrand() {
        return shopDao.queryBrandData();
    }
}
