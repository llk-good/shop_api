package com.llk.shop_api.controller;

import com.llk.shop_api.model.po.Type;
import com.llk.shop_api.model.vo.ResultData;
import com.llk.shop_api.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/type/")
@CrossOrigin
public class TypeController {
    @Autowired
    private TypeService typeService;

    /*
    1    查询所有的分类数据
路径   http://localhost:8080/api/type/getData

get请求

参数

返回值   {"code":200,"message":"提示",data:[{*}]}*/

    @GetMapping("getData")
    public ResultData queryData(){
        List<Type> list = typeService.queryData();
        return ResultData.success(list);
    }

    /*2    查询指定pid的数据

    路径   http://localhost:8080/api/type/getDataByPid

get请求

参数    Pid

返回值   {"code":200,"message":"提示",data:[{*}]}*/

    @GetMapping("getDataByPid")
    public ResultData queryDataByPid(Integer pid){
        List<Type> list = typeService.queryDataByPid(pid);
        return ResultData.success(list);
    }

/*
* 3  新增分类

路径   http://localhost:8080/api/type/add

   post请求

   参数    pid    name

返回值    {code:"",message:"",data:新增的id}
* */
    @PostMapping("add")
    public ResultData addType(Type ty){
        int i = typeService.addType(ty);
        return ResultData.success(i);
    }

    /*
    * 4   修改

  路径   http://localhost:8080/api/type/update

   post请求

  参数   id （必传）     pid   name  isDel

返回值     {code:"",message:""}
    * */
    @PostMapping("updateById")
    public ResultData updateById(Integer id){
        List<Type> list = typeService.updateById(id);
        return ResultData.success(list);
    }

    /*
    * 4   修改

  路径   http://localhost:8080/api/type/update

   post请求

  参数   id （必传）     pid   name  isDel

返回值     {code:"",message:""}
    * */
    @PostMapping("update")
    public ResultData updateType(Type type){
        typeService.updateType(type);
        return ResultData.success("");
    }
}
