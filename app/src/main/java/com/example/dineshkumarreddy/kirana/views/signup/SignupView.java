package com.example.dineshkumarreddy.kirana.views.signup;

public interface SignupView {
    void showLoading();

    void hideLoding();

    void navigateToSignIn();

    void showError(String message);
}
