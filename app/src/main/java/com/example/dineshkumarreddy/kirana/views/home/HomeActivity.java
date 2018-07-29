package com.example.dineshkumarreddy.kirana.views.home;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dineshkumarreddy.kirana.Utils.AppUtils;
import com.example.dineshkumarreddy.kirana.views.base.BaseActivity;
import com.example.dineshkumarreddy.kirana.views.signup.RegisterActivity;
import com.example.dineshkumarreddy.retrofit.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends BaseActivity implements HomeScreen {

    @BindView(R.id.mainContainer)
    FrameLayout frameLayout;

    @BindView(R.id.parent_container)
    DrawerLayout dl;

    private ActionBarDrawerToggle t;

    @BindView(R.id.navigationView)
    NavigationView navigationView;


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
        t = new ActionBarDrawerToggle(this, dl,R.string.app_name, R.string.app_name);

        dl.addDrawerListener(t);
        t.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.account:
                        Toast.makeText(getApplicationContext(), "Proflr clicked", Toast.LENGTH_LONG).show();

                    default:
                        return true;
                }

            }
        });
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
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
