package com.llk.shop_api.controller;

import com.llk.shop_api.model.po.Product;
import com.llk.shop_api.model.vo.ResultData;
import com.llk.shop_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/Prod")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("add")
    public ResultData addProd(Product product){
        productService.addProd(product);
        return ResultData.success("");
    }

    @GetMapping("queryProd")
    public ResultData queryProd(){
        List<Product> list = productService.queryProd();
        return ResultData.success(list);
    }
}
