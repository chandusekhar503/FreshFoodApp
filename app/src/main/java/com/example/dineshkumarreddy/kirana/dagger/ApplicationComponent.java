package com.example.dineshkumarreddy.kirana.dagger;

import android.app.Application;
import android.content.Context;

import com.example.dineshkumarreddy.kirana.MyApplication;

import dagger.Component;

/**
 * Created by dineshkumarreddy on 22/06/18.
 */

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MyApplication application);

    @Annotations.ApplicationContext
    Context getContext();

    Application getApplication();



}
