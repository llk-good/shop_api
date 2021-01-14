package com.llk.shop_api.service.impl;

import com.llk.shop_api.dao.BrandDao;
import com.llk.shop_api.model.po.Brand;
import com.llk.shop_api.model.vo.BrandPamas;
import com.llk.shop_api.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandDao brandDao;


    @Override
    public Map getBrandData(BrandPamas pamas) {
        Map map = new HashMap();
        Long count = brandDao.selectDataCount(pamas);
        map.put("count",count);

        List<Brand> list = brandDao.getBrandData(pamas);
        map.put("list",list);

        return map;
    }

/*//业务处理
        Map rs = new HashMap();
        Integer count = stuDao.queryDataCount(params);
        rs.put("count",count);
        //list
        List<Student> stus = stuDao.queryListDataByParams(params);
        rs.put("list",stus);
        return rs;*/
    @Override
    public void addBrand(Brand br) {
        br.setCreateDate(new Date());
        br.setUpdateDate(new Date());
        br.setIsDel(0);
        brandDao.addBrand(br);
    }

    @Override
    public void updateBrand(Brand br) {
        br.setUpdateDate(new Date());
         brandDao.updateBrand(br);
    }
}
