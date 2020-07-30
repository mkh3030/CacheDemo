package com.example.cacheh2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.example.cacheh2.domain.ProductDomain;
import com.example.cacheh2.service.CacheService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
public class CacheController {

    @Autowired
    CacheService cacheService;    

    @ApiOperation(value="Caregory List", notes="카테코리 리스트 호출")    
    @RequestMapping(value="getCategoryList", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> getCategoryList(HttpServletResponse res){ 
        HashMap<String, Object> rtnMap = new HashMap<>();
        try{
            rtnMap.put("categoryList", cacheService.getCategoryList());
        }catch(Exception e){
            res.setStatus(400);
            e.printStackTrace();
        }
      
        return rtnMap;        
    }

    @ApiOperation(value="특정 카테고리 안의 상품리스트 조회", notes="필수 파라미터 : categoryNo")    
    @RequestMapping(value="getCategoryProdList", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> getCategoryProdList(HttpServletResponse res, ProductDomain obj){ 
        HashMap<String, Object> rtnMap = new HashMap<>();
        try{
            rtnMap.put("categoryProductList", cacheService.getCategoryProdList(obj));
        }catch(Exception e){
            res.setStatus(400);
            e.printStackTrace();
        }      
        return rtnMap;        
    }

    
    @ApiOperation(value="상품정보 조회", notes="필수 파라미터 : productNo")    
    @RequestMapping(value="getProdInfo", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> getProdInfo(HttpServletResponse res, ProductDomain obj){ 
        HashMap<String, Object> rtnMap = new HashMap<>();
        try{
            rtnMap.put("productInfo", cacheService.getProdInfo(obj));
        }catch(Exception e){
            res.setStatus(400);
            e.printStackTrace();
        }      
        return rtnMap;        
    }
    
}