package com.k.temedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isNightMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int themeType = (int) SPUtils.get(this, "themeType", 0);
        if (themeType == 0) {
            setTheme(R.style.AppTheme);
        } else {
            setTheme(themeType);
        }


        if (savedInstanceState != null) {
            // 从已保存状态恢复成员的值
            isNightMode = savedInstanceState.getBoolean("isNightMode");
        }

        setContentView(R.layout.activity_main);
        initTheme();
        initNightMode();

    }

    private void initNightMode() {
        ToggleButton tg_night_mode = findViewById(R.id.tg_night_mode);

        boolean isNight = (boolean) SPUtils.get(this, "isNight", false);
        tg_night_mode.setChecked(isNight);

        tg_night_mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                isNightMode = isChecked;
                if (isChecked) {//夜间
                    System.out.println("夜间");
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {//白天
                    System.out.println("白天");
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                SPUtils.put(MainActivity.this, "isNight", isNightMode);
                recreate();

            }
        });
    }


    private void initTheme() {

        Button btn_blue = findViewById(R.id.btn_blue);
        Button btn_Pink = findViewById(R.id.btn_pink);
        Button btn_turquoise = findViewById(R.id.btn_turquoise);
        btn_blue.setOnClickListener(this);
        btn_Pink.setOnClickListener(this);
        btn_turquoise.setOnClickListener(this);

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("isNightMode", isNightMode);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_blue:
                SPUtils.put(this,"themeType",R.style.Blue);
                break;
            case R.id.btn_pink:
                SPUtils.put(this,"themeType",R.style.Pink);
                break;
            case R.id.btn_turquoise:
                SPUtils.put(this,"themeType",R.style.Turquoise);
                break;
        }
        recreate();
    }
}
