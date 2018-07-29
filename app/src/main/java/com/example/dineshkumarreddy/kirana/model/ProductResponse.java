package com.example.dineshkumarreddy.kirana.model;

import java.util.List;

public class ProductResponse {

    private List<Product> productList;
    private ApiResponseHeader responseHeader;

    public ProductResponse(List<Product> productList, ApiResponseHeader responseHeader) {
        this.productList = productList;
        this.responseHeader = responseHeader;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public ApiResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ApiResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductResponse{");
        sb.append("productList=").append(productList);
        sb.append(", responseHeader=").append(responseHeader);
        sb.append('}');
        return sb.toString();
    }
}