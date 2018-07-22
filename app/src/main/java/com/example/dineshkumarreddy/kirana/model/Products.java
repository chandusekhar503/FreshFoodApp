package com.example.dineshkumarreddy.kirana.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dineshkumarreddy on 22/07/18.
 */

public class Products implements Serializable {

    private static final long serialVersionUID = 3167898476444088587L;

    private String itemName;
    private String itemCost;

    public Products(String itemName, String itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCost() {
        return itemCost;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Products{");
        sb.append("itemName='").append(itemName).append('\'');
        sb.append(", itemCost='").append(itemCost).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
