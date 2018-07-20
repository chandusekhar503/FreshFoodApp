package com.example.dineshkumarreddy.kirana.Utils;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by dineshkumarreddy on 27/06/18.
 */

public class AppUtils {
    public static void replace(FragmentManager manager, @IdRes int layout, Fragment fragment, int transitionStyle) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(layout, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.setTransition(transitionStyle);
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commitAllowingStateLoss();
    }
}
