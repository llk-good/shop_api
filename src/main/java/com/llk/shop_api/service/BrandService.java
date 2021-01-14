package com.llk.shop_api.service;

import com.llk.shop_api.model.po.Brand;
import com.llk.shop_api.model.vo.BrandPamas;

import java.util.List;
import java.util.Map;

public interface BrandService {

    Map getBrandData(BrandPamas pamas);

    void addBrand(Brand br);

    void updateBrand(Brand br);
}
