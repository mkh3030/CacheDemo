package com.example.cacheh2.service;

import com.example.cacheh2.domain.ProductDomain;

public interface ProductService {

    int updateProductName(ProductDomain obj) throws Exception;

    int updateProductPrice(ProductDomain obj) throws Exception;

    int updateCategoryName(ProductDomain obj) throws Exception;
    
}