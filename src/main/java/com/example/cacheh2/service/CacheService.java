package com.example.cacheh2.service;

import java.util.List;

import com.example.cacheh2.domain.ProductDomain;

public interface CacheService {

    List<ProductDomain> getCategoryList() throws Exception;

    List<ProductDomain> getCategoryProdList(ProductDomain obj) throws Exception;

    ProductDomain getProdInfo(ProductDomain obj) throws Exception;
    
}