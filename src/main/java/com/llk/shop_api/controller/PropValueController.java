package com.llk.shop_api.controller;

import com.llk.shop_api.model.po.PropValue;
import com.llk.shop_api.model.vo.ResultData;
import com.llk.shop_api.service.PropValueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/propvalue/")
@CrossOrigin
public class PropValueController {

    @Resource
    private PropValueService propValueService;

    @GetMapping("getData")
    public ResultData getData(Integer propid){
        List<PropValue> list = propValueService.getDataByPid(propid);
        return ResultData.success("");
    }

    @PostMapping("add")
    public ResultData add(PropValue prop){
        propValueService.add(prop);
        return ResultData.success("");
    }

}
