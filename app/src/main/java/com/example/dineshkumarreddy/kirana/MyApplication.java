package com.example.dineshkumarreddy.kirana;

import android.app.Application;

import com.example.dineshkumarreddy.kirana.dagger.ApplicationComponent;
import com.example.dineshkumarreddy.kirana.dagger.ApplicationModule;
import com.example.dineshkumarreddy.kirana.dagger.DaggerApplicationComponent;


/**
 * Created by dineshkumarreddy on 22/06/18.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationComponent applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

}
