package com.example.dineshkumarreddy.kirana.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dineshkumarreddy on 22/07/18.
 */

public class Product implements Serializable {

    private static final long serialVersionUID = 3167898476444088587L;

    private String productId;
    private String productName;
    private String productQuantity;
    private String productPrice;


    public Product(String productId, String productName, String productQuantity, String productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("productId='").append(productId).append('\'');
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", productQuantity='").append(productQuantity).append('\'');
        sb.append(", productPrice='").append(productPrice).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
