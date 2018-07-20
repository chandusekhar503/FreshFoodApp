package com.example.dineshkumarreddy.kirana.views.home;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.dineshkumarreddy.kirana.Utils.AppUtils;
import com.example.dineshkumarreddy.kirana.views.base.BaseActivity;
import com.example.dineshkumarreddy.kirana.views.signup.RegisterActivity;
import com.example.dineshkumarreddy.retrofit.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends BaseActivity implements HomeScreen {

    @BindView(R.id.progres_bar)
    ProgressBar progres_bar;

    @BindView(R.id.mainContainer)
    FrameLayout frameLayout;

    public static Intent callingIntent(Context context){
        Intent i = new Intent(context, HomeActivity.class);
        return i;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AppUtils.replace(getSupportFragmentManager(), R.id.mainContainer, HomeFragment
                .newInstance(), FragmentTransaction.TRANSIT_NONE);



    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void showLoading() {
        progres_bar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoding() {
        progres_bar.setVisibility(View.VISIBLE);
    }

    @Override
    public void launchRegisterActitivty() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @Override
    public void launchHome() {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
