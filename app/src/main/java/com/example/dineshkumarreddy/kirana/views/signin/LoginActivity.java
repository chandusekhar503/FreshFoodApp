package com.example.dineshkumarreddy.kirana.views.signin;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.dineshkumarreddy.kirana.views.home.HomeActivity;
import com.example.dineshkumarreddy.kirana.views.signup.RegisterActivity;
import com.example.dineshkumarreddy.kirana.Utils.AppUtils;
import com.example.dineshkumarreddy.kirana.views.base.BaseActivity;
import com.example.dineshkumarreddy.retrofit.R;


import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends BaseActivity implements SignInScreen {

    @BindView(R.id.mainContainer)
    FrameLayout frameLayout;

    public static Intent callingIntent(Context context){
        Intent i = new Intent(context, LoginActivity.class);
        return i;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AppUtils.replace(getSupportFragmentManager(), R.id.mainContainer, SignInFragment
                .newInstance(), FragmentTransaction.TRANSIT_NONE);



    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoding() {
    }

    @Override
    public void launchRegisterActitivty() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @Override
    public void launchHome() {
        startActivity(new Intent(this, HomeActivity.class));
    }
}
