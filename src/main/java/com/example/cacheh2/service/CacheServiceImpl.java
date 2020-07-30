package com.example.cacheh2.service;

import java.util.List;
import java.util.Map.Entry;

import com.example.cacheh2.domain.LRUCache;
import com.example.cacheh2.domain.ProductDomain;
import com.example.cacheh2.mapper.CacheMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    CacheMapper cacheMapper;

    //cache 사이즈 정함. 오래된 캐시는 사이즈 넘어가면 삭제
    LRUCache prodInfoCache = new LRUCache(50);
    LRUCache categoryCache = new LRUCache(1);
    LRUCache categoryProdCache = new LRUCache(10);


    @Override
    public List<ProductDomain> getCategoryList() throws Exception {
        // TODO Auto-generated method stub

        List<ProductDomain> categoryList = (List<ProductDomain>) categoryCache.get("categoryList");
        if(categoryList==null){            
            System.out.println("category NULL");
            categoryList = cacheMapper.getCategoryList();
            if(categoryList!=null){
                categoryCache.put("categoryList", categoryList);            
            }
        }else{
            //삭제하고 재삽입하여 최신entry로 유지
            categoryCache.remove("categoryList");
            categoryCache.put("categoryList", categoryList);
        }
        return categoryList;
    }

    @Override
    public List<ProductDomain> getCategoryProdList(ProductDomain obj) throws Exception {
        // TODO Auto-generated method stub
        List<ProductDomain> cateProdList = (List<ProductDomain>) categoryProdCache.get(""+obj.getCategoryNo());
        if(cateProdList==null){
            System.out.println("CP NULL");
            cateProdList = cacheMapper.getCategoryProdList(obj);
            if(cateProdList!=null && cateProdList.size()>0){
                categoryProdCache.put(""+cateProdList.get(0).getCategoryNo(), cateProdList);
            }
        }else{
            //삭제하고 재삽입하여 최신enry로 유지
            categoryProdCache.remove(""+cateProdList.get(0).getCategoryNo());
            categoryProdCache.put(""+cateProdList.get(0).getCategoryNo(), cateProdList);
        }
        return cateProdList;
    }

    @Override
    public ProductDomain getProdInfo(ProductDomain obj) throws Exception {
        // TODO Auto-generated method stub

        System.out.println(obj.toString());
        prodInfoCache.get(obj.getProductName());        
        ProductDomain prodInfo = new ProductDomain();

        prodInfo = (ProductDomain) prodInfoCache.get(""+obj.getProductNo());

        if(prodInfo==null){
            System.out.println("PROD NULL");
            prodInfo = cacheMapper.getProdInfo(obj);
            //product에 중복값이 있어 name, price, categoryName 으로 그룹핑하고 productName만 있을 경우 productNo의 최소값으로 리턴
            if(prodInfo!=null){                        
                prodInfoCache.put(""+prodInfo.getProductNo(), prodInfo);
            }
        }else{
            //삭제하고 재삽입하여 최신enry로 유지
            prodInfoCache.remove(""+prodInfo.getProductNo());
            prodInfoCache.put(""+prodInfo.getProductNo(), prodInfo);
        }
        // System.out.println(prodInfoCache);
        return prodInfo;
    }

    //스케줄링으로 제일 오랬동안 사용되지 않은 캐시 삭제 LRU
    //자주 조회되지 않는 데이터는 조회될 확률 낮다고 판단하여 캐시에서 삭제
    @Scheduled(fixedRate = 60*1000) //60초
    public void cacheEviction(){
        Entry prodInfoEntry = (Entry) prodInfoCache.getEldestEntry();        
        if(prodInfoEntry!=null){
            prodInfoCache.remove(prodInfoEntry.getKey());
        }
        categoryCache.remove("categoryList");        
        Entry cateProdEntry = (Entry) categoryProdCache.getEldestEntry();
        if(cateProdEntry!=null){
            categoryCache.remove(cateProdEntry.getKey());
        }
    }

    // 스케줄링으로 캐쉬 내용 update 함
    @Scheduled(fixedRate = 30*1000)
    public void cacheRefresh(){ 
        updateCategoryCache();
        updateProdInfoCache();
        updateCateProdCache();        
    }
    private void updateProdInfoCache(){
        Object[] arr = prodInfoCache.keySet().toArray();        
        for(int i=0;i<arr.length;i++){
            ProductDomain obj = new ProductDomain();
            obj.setProductNo(Integer.parseInt(arr[i].toString()));
            ProductDomain productInfo = cacheMapper.getProdInfo(obj);
            //삭제 됐을경우 캐시에서 삭제
            if(productInfo==null){
                prodInfoCache.remove(""+obj.getProductNo());
            }else{
                prodInfoCache.put(""+obj.getProductNo(),productInfo);
            }
        }
    }
    private void updateCateProdCache(){
        Object[] arr = categoryProdCache.keySet().toArray();        
        for(int i=0;i<arr.length;i++){
            ProductDomain obj = new ProductDomain();
            obj.setCategoryNo(Integer.parseInt(arr[i].toString()));
            List<ProductDomain> cateProdList = cacheMapper.getCategoryProdList(obj);
            //삭제 됐을경우 캐시에서 삭제
            if(cateProdList==null){
                categoryProdCache.remove(""+obj.getCategoryNo());
            }else{
                categoryProdCache.put(""+obj.getCategoryNo(),cateProdList);
            }            
        }
    }

    private void updateCategoryCache(){        
        categoryCache.put("categoryList", cacheMapper.getCategoryList());
    }
    
}