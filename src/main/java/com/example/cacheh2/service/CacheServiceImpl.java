package com.example.cacheh2.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.cacheh2.LRUCache;
import com.example.cacheh2.domain.CacheDomain;
import com.example.cacheh2.domain.ProductDomain;
import com.example.cacheh2.mapper.CacheMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    CacheMapper cacheMapper;


    LinkedHashMap<String, Object> cacheMap = new LinkedHashMap<String, Object>();
    LinkedHashMap<String, CacheDomain> prodInfoCache = new LinkedHashMap<String, CacheDomain>(5);
    @Override
    public List<ProductDomain> getCategoryList() throws Exception {
        // TODO Auto-generated method stub
        List<ProductDomain> categoryList = (List<ProductDomain>) cacheMap.get("categoryList");
        if(categoryList==null || categoryList.isEmpty()){            
            System.out.println("EMPTY get Category");
            categoryList = cacheMapper.getCategoryList();
            cacheMap.put("categoryList", categoryList);            
        }else{

        }
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
        System.out.println(obj.toString());
        prodInfoCache.get(obj.getProductName());        
        ProductDomain prodInfo = new ProductDomain();


        CacheDomain cacheItem = prodInfoCache.get(obj.getProductName());
        long time = System.currentTimeMillis();
        if(cacheItem==null ){
            System.out.println("NULL");            
            cacheItem = new CacheDomain();
            prodInfo = cacheMapper.getProdInfo(obj);
            cacheItem.setItem(prodInfo);
            cacheItem.setTime(time);
            cacheItem.setKey(obj.getProductName());
            cacheItem.setCallCnt(1);
            prodInfoCache.put(obj.getProductName(), cacheItem);
        }else{
            System.out.println("TIME:"+(time-cacheItem.getTime()));
            if(time-cacheItem.getTime()>= 20*1000L){
                prodInfoCache.remove(obj.getProductName());
                cacheItem = new CacheDomain();
                prodInfo = cacheMapper.getProdInfo(obj);
                cacheItem.setItem(prodInfo);
                cacheItem.setTime(time);
                cacheItem.setKey(obj.getProductName());
                cacheItem.setCallCnt(1);
                prodInfoCache.put(obj.getProductName(), cacheItem);                
            }else{
                System.out.println("NOT NULL");
                prodInfo = cacheItem.getItem();            
                cacheItem.setCallCnt(cacheItem.getCallCnt()+1);
                cacheItem.setTime(time);
                System.out.println(prodInfoCache.get(obj.getProductName()));
            }
        }
        
        System.out.println(prodInfoCache);

        return prodInfo;
    }

    @Scheduled(fixedRate = 10*1000)
    public void cacheEviction(){
        
        System.out.println("Cache Eviction!!!!");        
    }
    
}