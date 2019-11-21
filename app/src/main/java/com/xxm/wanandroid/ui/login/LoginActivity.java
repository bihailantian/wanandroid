package com.xxm.wanandroid.ui.login;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.xxm.wanandroid.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private TextView tvLogin;
    private TextView tvRegistered;
    private ImageView ivBg;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvLogin = findViewById(R.id.tv_login);
        tvRegistered = findViewById(R.id.tv_registered);
        ivBg = findViewById(R.id.iv_bg);
        viewPager = findViewById(R.id.vp_pager);

        tvLogin.setOnClickListener(this);
        tvRegistered.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        ObjectAnimator translationX;
        int offerX = 0;
        switch (v.getId()) {
            case R.id.tv_login:
                offerX = tvRegistered.getWidth();
                ObjectAnimator oa = ObjectAnimator.ofFloat(ivBg, "translationX", offerX, 0);
                oa.setInterpolator(new DecelerateInterpolator());
                oa.setDuration(500);
                oa.start();

                tvRegistered.setTextColor(Color.WHITE);
                tvLogin.setTextColor(Color.BLACK);
                break;

            case R.id.tv_registered:
                offerX = tvLogin.getWidth();
                translationX = ObjectAnimator.ofFloat(ivBg, "translationX", 0f, offerX);
                translationX.setInterpolator(new DecelerateInterpolator());
                translationX.setDuration(500).start();

                tvRegistered.setTextColor(Color.BLACK);
                tvLogin.setTextColor(Color.WHITE);
                break;
        }
        Log.e(TAG, "offerX=" + offerX);
    }
}
