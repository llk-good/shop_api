package com.llk.shop_api.controller;

import com.llk.shop_api.model.po.Property;
import com.llk.shop_api.model.vo.PropPamas;
import com.llk.shop_api.model.vo.ResultData;
import com.llk.shop_api.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/prop/")
@CrossOrigin
public class ProController {

    @Autowired
    private ProService proService;

    /*
    * 1    查询所有的分类数据
路径   http://localhost:8080/api/prop/getData
get请求
参数
返回值   {"code":200,"message":"提示",data:[{*}]}
    *
    * */
    @GetMapping("getData")
    public ResultData getAllData(PropPamas pamas){
        if (pamas.getPage()==0){
            return ResultData.error(400,"参数不合法");
        }
        if (pamas.getSize()==0){
            return ResultData.error(400,"参数不合法");
        }
        Map map = proService.getAllData(pamas);
        return ResultData.success(map);
    }



    /*
    *3  新增分类
路径   http://localhost:8080/api/prop/add
post请求
参数    pid    name
返回值    {code:"",message:"",data:新增的id}
    *
    * */



    /*
    *
    *4   修改
  路径   http://localhost:8080/api/prop/update
   post请求
  参数   id （必传）     pid   name  isDel
返回值     {code:"",message:""}
    * */


}
