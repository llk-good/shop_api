package com.llk.shop_api.controller;

import com.llk.shop_api.model.po.Product;
import com.llk.shop_api.model.vo.ProdPamas;
import com.llk.shop_api.model.vo.ResultData;
import com.llk.shop_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/Prod")
public class ProductController {

    @Autowired
    private ProductService productService;


    /*
     * 新增
     *
     * Url:  http//localhost:8080/localhost:8080/api/Prod/add
     *
     * 请求方式： post
     * */
    @PostMapping("add")
    public ResultData addProd(Product product){
        productService.addProd(product);
        return ResultData.success("");
    }

    /*
     * 分页条件查询
     *
     * Url: http//localhost:8080/localhost:8080/api/Prod/queryProd
     *
     * 请求方式 get
     *
     * */
    @GetMapping("queryProd")
    public ResultData queryProd(ProdPamas pamas){
        Map list = productService.queryProd(pamas);
        return ResultData.success(list);
    }
}
