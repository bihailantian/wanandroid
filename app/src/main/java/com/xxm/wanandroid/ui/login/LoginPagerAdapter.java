package com.xxm.wanandroid.ui.login;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class LoginPagerAdapter extends PagerAdapter {

    private List<View> pageList;
    private String[] mTitles;

    LoginPagerAdapter(List<View> pageList, String[] mTitles) {
        this.pageList = pageList;
        this.mTitles = mTitles;
    }

    @Override
    public int getCount() {
        return pageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View contentView = pageList.get(position);
        container.addView(contentView);
        return contentView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}