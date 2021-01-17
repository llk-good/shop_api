package com.llk.shop_api.controller;

import com.llk.shop_api.model.po.Brand;
import com.llk.shop_api.model.vo.BrandPamas;
import com.llk.shop_api.model.vo.ResultData;
import com.llk.shop_api.service.BrandService;
import com.llk.shop_api.utils.FileInput;
import com.llk.shop_api.utils.OssFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/brand/")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;


    /*1    查询所有的分类数据
路径   http://localhost:8080/api/brand/getData
get请求
参数
返回值   {"code":200,"message":"提示",data:[{*}]}*/

    @GetMapping("getData")
    public ResultData getData(BrandPamas pamas){
        if (pamas.getPage()==null){
            return ResultData.error(400,"数据不合法");
        }
        if (pamas.getSize()==null){
            return ResultData.error(400,"数据不合法");
        }
        Map map = brandService.getBrandData(pamas);
        return ResultData.success(map);
    }

/*
* 3  新增分类

路径   http://localhost:8080/api/brand/add

   post请求

   参数    pid    name

返回值    {code:"",message:"",data:新增的id}
* */

    @PostMapping("add")
    public ResultData add(Brand br){
        brandService.addBrand(br);
        return ResultData.success("");
    }

    /*
   * 4   修改

 路径   http://localhost:8080/api/type/update

  post请求

 参数   id （必传）     pid   name  isDel

返回值     {code:"",message:""}
   * */
    @PostMapping("update")
    public ResultData updateBrand(Brand br){
         brandService.updateBrand(br);
        return ResultData.success("");
    }


    /*
     * 路径：http://localhost:8080/car/upload
     * 请求方式：post
     * */
    @PostMapping("upload")
    public ResultData upload(MultipartFile file, HttpServletRequest request){
        String imgages = FileInput.saveFile(file, "images", request);
        return ResultData.success(imgages);
    }

    @RequestMapping("uploadFile")
    public ResultData uploadFile(MultipartFile file) throws IOException {
        //处理新名称
        String originalFilename = file.getOriginalFilename();
        //防止中文引起的错误
        String newName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //存储路径
        newName="imgs/"+newName;
        return ResultData.success(OssFileUtils.uploadFile(file.getInputStream(),newName));
    }
}
