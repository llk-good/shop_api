package com.llk.shop_api.controller;

import com.llk.shop_api.model.po.Brand;
import com.llk.shop_api.model.vo.ResultData;
import com.llk.shop_api.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/shop/")
@CrossOrigin
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("queryBrand")
    public ResultData queryBrand(){
        List<Brand> list = shopService.queryBrand();
        return ResultData.success(list);
    }

}
