package com.example.cacheh2.mapper;

import com.example.cacheh2.domain.ProductDomain;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    int updateProductName(ProductDomain obj);

    int updateProductPrice(ProductDomain obj);

    int updateCategoryName(ProductDomain obj);
    
}