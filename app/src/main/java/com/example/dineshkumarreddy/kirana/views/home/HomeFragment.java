package com.example.dineshkumarreddy.kirana.views.home;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dineshkumarreddy.kirana.views.base.BaseFragment;
import com.example.dineshkumarreddy.retrofit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvp.home.HomePresenter;
import mvp.home.HomePresenterImpl;
import mvp.signin.SignInPresenter;
import mvp.signin.SignInPresenterImpl;

/**
 * Created by dineshkumarreddy on 21/06/18.
 */

public class HomeFragment extends BaseFragment implements HomeView {

    @BindView(R.id.tvSignUp)
    TextView tvSignUp;

    @BindView(R.id.etMobile)
    EditText etMobile;

    @BindView(R.id.etPassword)
    EditText etPassword;

    HomeScreen homeScreen;

    HomePresenter presenter;

    public static HomeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        presenter = new HomePresenterImpl();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeScreen = (HomeScreen) context;
    }

    @OnClick(R.id.tvSignUp)
    public void OnSignUpClick(){
        homeScreen.launchRegisterActitivty();
    }

    @OnClick(R.id.btnLogin)
    public void OnSignInClick(){
        presenter.signIn(etMobile.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(presenter!= null){
            presenter.attachView(this);
        }
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoding() {

    }

    @Override
    public void navigateToHome() {
        homeScreen.launchHome();
    }

    @Override
    public void showError(String message) {
        Snackbar.make(getView(), message, 400).show();
    }
}
