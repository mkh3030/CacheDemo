package com.example.cacheh2.mapper;

import java.util.List;

import com.example.cacheh2.domain.ProductDomain;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CacheMapper {

    List<ProductDomain> getCategoryList();

    List<ProductDomain> getCategoryProdList(ProductDomain obj);

    ProductDomain getProdInfo(ProductDomain obj);
}