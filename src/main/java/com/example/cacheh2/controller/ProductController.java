package com.example.cacheh2.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.example.cacheh2.domain.ProductDomain;
import com.example.cacheh2.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

@Controller
public class ProductController {

    @Autowired
    ProductService prodService;


    @ApiOperation(value="상품명 변경", notes="필수 파라미터 : productNo, productName")    
    @RequestMapping(value="updateProductName", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> updateProduct(HttpServletResponse res, ProductDomain obj){ 
        HashMap<String, Object> rtnMap = new HashMap<>();
        try{
            System.out.println(obj);            
            rtnMap.put("updateProductName", prodService.updateProductName(obj));
        }catch(Exception e){
            res.setStatus(400);
            e.printStackTrace();
        }      
        return rtnMap;        
    }

    @ApiOperation(value="상품가격 변경", notes="필수 파라미터 : productNo, price")    
    @RequestMapping(value="updateProductPrice", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> updateProductPrice(HttpServletResponse res, ProductDomain obj){ 
        HashMap<String, Object> rtnMap = new HashMap<>();
        try{
            System.out.println(obj);
            rtnMap.put("updateProductPrice", prodService.updateProductPrice(obj));
        }catch(Exception e){
            res.setStatus(400);
            e.printStackTrace();
        }      
        return rtnMap;        
    }

    @ApiOperation(value="카테코리명 변경", notes="필수 파라미터 : categoryNo, categoryName")    
    @RequestMapping(value="updateCategoryName", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> updateCategoryName(HttpServletResponse res, ProductDomain obj){ 
        HashMap<String, Object> rtnMap = new HashMap<>();
        try{
            System.out.println(obj);
            rtnMap.put("updateCategoryName", prodService.updateCategoryName(obj));
        }catch(Exception e){
            res.setStatus(400);
            e.printStackTrace();
        }      
        return rtnMap;        
    }


    
}