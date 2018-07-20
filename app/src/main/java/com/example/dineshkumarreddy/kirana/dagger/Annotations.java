package com.example.dineshkumarreddy.kirana.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;

/**
 * Created by dineshkumarreddy on 22/06/18.
 */

public class Annotations {
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ActivityContext {
    }
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ApplicationContext {
    }
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DatabaseInfo {
    }
    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerActivity {
    }
}
