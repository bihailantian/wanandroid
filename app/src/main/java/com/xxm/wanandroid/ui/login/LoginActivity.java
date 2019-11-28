package com.xxm.wanandroid.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.xxm.wanandroid.R;
import com.xxm.wanandroid.base.BaseActivity;
import com.xxm.wanandroid.utils.ViewPagerScroller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends BaseActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private ActionBar actionBar;
    private final String[] mTitles = {"登录", "注册"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.login);
        }

        ViewPager viewPager = findViewById(R.id.vp_pager);

        // indicator圆角色块
        SlidingTabLayout tabLayout_9 = findViewById(R.id.tl_9);

        View pageLogin = LayoutInflater.from(mActivity).inflate(R.layout.page_login, null);
        View pageRegister = LayoutInflater.from(mActivity).inflate(R.layout.page_register, null);

        List<View> pageList = new ArrayList<>();
        pageList.add(pageLogin);
        pageList.add(pageRegister);
        viewPager.setAdapter(new LoginPagerAdapter(pageList, mTitles));
        tabLayout_9.setViewPager(viewPager);


        //自定义ViewPager的滚动时间
        try {
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            ViewPagerScroller scroller = new ViewPagerScroller(mActivity, new LinearInterpolator());
            field.set(viewPager, scroller);
            scroller.setmDuration(300);
        } catch (Exception e) {
            e.printStackTrace();
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    actionBar.setTitle(R.string.login);
                } else if (position == 1) {
                    actionBar.setTitle(R.string.registered);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) { //点击返回图标事件
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
