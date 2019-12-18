package com.xxm.wanandroid;

import android.app.Application;

import com.billy.android.loading.Gloading;
import com.xxm.wanandroid.loading.GlobalAdapter;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Gloading.debug(BuildConfig.DEBUG);
        Gloading.initDefault(new GlobalAdapter());
    }
}
