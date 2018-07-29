package com.example.dineshkumarreddy.kirana.model;

import java.util.List;

public class CategoryResponse {

    private List<Category> categoryList;
    private ApiResponseHeader responseHeader;


    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public ApiResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ApiResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CategoryResponse{");
        sb.append("categoryList=").append(categoryList);
        sb.append(", responseHeader=").append(responseHeader);
        sb.append('}');
        return sb.toString();
    }
}
