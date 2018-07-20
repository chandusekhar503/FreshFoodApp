package com.example.dineshkumarreddy.kirana.views.home;

public interface HomeView {
    void showLoading();

    void hideLoding();

    void navigateToHome();

    void showError(String message);
}
