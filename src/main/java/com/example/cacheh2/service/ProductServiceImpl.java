package com.example.cacheh2.service;

import com.example.cacheh2.domain.ProductDomain;
import com.example.cacheh2.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper prodMapper;

    @Override
    public int updateProductName(ProductDomain obj) throws Exception {
        // TODO Auto-generated method stub
        return prodMapper.updateProductName(obj);
    }

    @Override
    public int updateProductPrice(ProductDomain obj) throws Exception {
        // TODO Auto-generated method stub
        return prodMapper.updateProductPrice(obj);
    }

    @Override
    public int updateCategoryName(ProductDomain obj) throws Exception {
        // TODO Auto-generated method stub
        return prodMapper.updateCategoryName(obj);
    }
    
}