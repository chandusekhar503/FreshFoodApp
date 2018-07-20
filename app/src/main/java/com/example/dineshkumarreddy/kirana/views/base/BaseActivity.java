package com.example.dineshkumarreddy.kirana.views.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.dineshkumarreddy.kirana.views.signin.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dineshkumarreddy on 30/06/18.
 */

public class BaseActivity extends AppCompatActivity implements BaseFragment.BackHandlerInterface{

    private List<BaseFragment> baseFragmentList = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    private BaseFragment getCurrentFragment() {
        int size = baseFragmentList.size();
        if (size > 0)
            return baseFragmentList.get(size - 1);
        return null;
    }

    @Override
    public void setSelectedFragment(BaseFragment selectedFragment) {
        baseFragmentList.add(selectedFragment);
    }

    @Override
    public void removeSelectedFragment(BaseFragment backHandledFragment) {
        baseFragmentList.remove(backHandledFragment);
    }

    private void backKeyHandler() {
        BaseFragment selectedFragment = getCurrentFragment();
        if (selectedFragment == null || !selectedFragment.onBackPressed()) {
            handleBackKey();
        }
    }

    // Screens may override this function for necessary behaviours
    protected void handleBackKey() {
        //if user is on login screen and press back button then finish the activity and return,otherwise it will go to the next check
        if (this.isTaskRoot() && this.getClass().getSimpleName().equals("HomeActivity")) {
            closeKeyboard(this);
            finish();
            return;
        }
        if (this.isTaskRoot() && this.getClass().getSimpleName().equals("RegisterActivity")) {
            startActivity(LoginActivity.callingIntent(this));
            finish();
            return;

        }
        if (this.isTaskRoot() && !this.getClass().getSimpleName().equals("HomeActivity")) {
//            startActivity(HomeNavigation.getCallingIntent(this));

        }
        closeKeyboard(this);
        finish();
    }

    @Override
    public void onBackPressed() {

        backKeyHandler();
    }

    public static void closeKeyboard(Activity activity) {
        try {
            View view = activity.getCurrentFocus();
            if (view != null) {
                InputMethodManager mgr = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);

            }

        } catch (Exception e) {
            System.out.println("Exception while closing the softkeypad");
            System.out.println("exception: , e.getMessage()");
        }
    }
}
