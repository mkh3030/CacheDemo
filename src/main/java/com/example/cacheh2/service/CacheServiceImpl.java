package com.example.cacheh2.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.example.cacheh2.domain.ProductDomain;
import com.example.cacheh2.mapper.CacheMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    CacheMapper cacheMapper;

    HashMap<String, Object> cacheMap = new HashMap<>();

    @Override
    public List<ProductDomain> getCategoryList() throws Exception {
        // TODO Auto-generated method stub

        List arr = new LinkedList<>();        
        

        List<ProductDomain> categoryList = (List<ProductDomain>) cacheMap.get("categoryList");
        // if(categoryList==null || categoryList.isEmpty()){            
        //     System.out.println("EMPTY get Category");
        //     categoryList = cacheMapper.getCategoryList();
        //     cacheMap.put("categoryList", categoryList);            
        // }else{
        //     cacheMap.computeIfPresent(key, remappingFunction);
        // }
        return categoryList;
    }

    @Override
    public List<ProductDomain> getCategoryProdList(ProductDomain obj) throws Exception {
        // TODO Auto-generated method stub
        return cacheMapper.getCategoryProdList(obj);
    }

    @Override
    public ProductDomain getProdInfo(ProductDomain obj) throws Exception {
        // TODO Auto-generated method stub
        return cacheMapper.getProdInfo(obj);
    }
    
}