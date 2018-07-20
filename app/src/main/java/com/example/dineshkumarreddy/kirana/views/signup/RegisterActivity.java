package com.example.dineshkumarreddy.kirana.views.signup;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.dineshkumarreddy.kirana.Utils.AppUtils;
import com.example.dineshkumarreddy.kirana.views.base.BaseActivity;
import com.example.dineshkumarreddy.retrofit.R;

import butterknife.ButterKnife;

/**
 * Created by dineshkumarreddy on 28/06/18.
 */

public class RegisterActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AppUtils.replace(getSupportFragmentManager(), R.id.mainContainer, SignUpFragment
                .newInstance(), FragmentTransaction.TRANSIT_NONE);
    }
}
