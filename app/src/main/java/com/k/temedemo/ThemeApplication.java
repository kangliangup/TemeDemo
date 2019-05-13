package com.k.temedemo;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;


/**
 * Created by 小康生活 on 2019/5/10.
 */
public class ThemeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        setTheme(R.style.Blue);




        boolean isNight = (boolean) SPUtils.get(this, "isNight", false);
        if(isNight){
            AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_NO);
        }

    }
}
