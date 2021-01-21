package com.llk.shop_api.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.llk.shop_api.dao.ProductAttrDao;
import com.llk.shop_api.dao.ProductDao;
import com.llk.shop_api.model.po.Product;
import com.llk.shop_api.model.po.ProductAttr;
import com.llk.shop_api.model.vo.ProdPamas;
import com.llk.shop_api.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    //
    @Resource
    private ProductAttrDao productAttrDao;


    @Override
    public Map queryProd(ProdPamas pamas) {
        Map map = new HashMap();
        Long count = productDao.queryProdCount(pamas);
        map.put("count",count);

        List<Product> list = productDao.queryProdData(pamas);
        map.put("list",list);

        return map;
    }

    @Override
    public void addProd(Product product, String attr, String sku) {
        product.setCreateDate(new Date());
        product.setUpdateDate(new Date());
        productDao.addProd(product);
        // 声明属性数据的对象
        List<ProductAttr> list = new ArrayList<>();
        //批量新增
        //将attr的json数组字符串 转为json数组对象
        JSONArray objects = JSONObject.parseArray(attr);
        for (int i = 0; i < objects.size(); i++) {
            //构建属性数据对象
            ProductAttr te = new ProductAttr();
            //设置对应的商品id
            te.setProId(product.getId());
            te.setAttrData(objects.get(i).toString());
            //放入集合
            list.add(te);

            //将sku的json数组字符串转为json数组对象
            JSONArray objectssku = JSONObject.parseArray(sku);
            for (int j = 0; j <objectssku.size() ; j++) {
                //得到具体一个json对象
                JSONObject data = (JSONObject) objectssku.get(i);
                //构建属性数据对象
                ProductAttr tek  = new ProductAttr();
                //设置对应的商品id
                tek.setProId(product.getId());
                tek.setPrice(data.getDouble("pricess"));
                tek.setStorcks(data.getInteger("storcks"));
                data.remove("price");
                data.remove("storck");
                tek.setAttrData(objectssku.get(i).toString());
                //放入集合
                list.add(tek);
            }
                productAttrDao.adds(list);
        }
    }


    @Override
    public void upadte(Product prod) {
        prod.setUpdateDate(new Date());
        productDao.upate(prod);
    }


}
