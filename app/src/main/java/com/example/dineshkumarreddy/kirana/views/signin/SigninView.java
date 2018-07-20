package com.example.dineshkumarreddy.kirana.views.signin;

public interface SigninView {
    void showLoading();

    void hideLoding();

    void navigateToHome();

    void showEmailNotVerifiedDialog();

    void showError(String message);
}
