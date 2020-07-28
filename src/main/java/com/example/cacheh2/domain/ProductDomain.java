package com.example.cacheh2.domain;

public class ProductDomain {

    private int categoryNo;
    private String categoryName;
    private String parentNo;
    private int depth;

    private int productNo;
    private String brandName;
    private String productName;

    private double price;

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDomain [brandName=" + brandName + ", categoryName=" + categoryName + ", categoryNo=" + categoryNo
                + ", depth=" + depth + ", parentNo=" + parentNo + ", price=" + price + ", productName=" + productName
                + ", productNo=" + productNo + "]";
    }

    


    
}