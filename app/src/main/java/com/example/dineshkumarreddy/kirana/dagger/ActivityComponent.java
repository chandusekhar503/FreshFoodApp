package com.example.dineshkumarreddy.kirana.dagger;

import com.example.dineshkumarreddy.kirana.views.signin.LoginActivity;

import dagger.Component;

/**
 * Created by dineshkumarreddy on 22/06/18.
 */

@Annotations.PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity loginActivity);

}
