package com.example.dineshkumarreddy.kirana.views.home;

import com.example.dineshkumarreddy.kirana.model.Category;
import com.example.dineshkumarreddy.kirana.model.Product;

import java.util.List;

public interface HomeView {
    void showLoading();

    void hideLoding();

    void navigateToHome();

    void showError(String message);

    void showProducts(List<Product> productList);

    void showCategories(List<Category> categoryList);
}
