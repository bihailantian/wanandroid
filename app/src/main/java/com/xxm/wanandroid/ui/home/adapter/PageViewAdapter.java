package com.xxm.wanandroid.ui.home.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.xxm.wanandroid.ui.home.pages.BasePage;

import java.util.List;

public class PageViewAdapter extends PagerAdapter {


    private List<BasePage> pageList;
    private List<String> mTitleList;

    public PageViewAdapter(List<BasePage> pageList, List<String> mTitleList) {
        this.pageList = pageList;
        this.mTitleList = mTitleList;
    }

    @Override
    public int getCount() {
        return pageList != null ? pageList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        BasePage page = pageList.get(position);
        container.addView(page.mRootPage);
        page.initData();//初始化数据
        return page.mRootPage;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    //配置标题的方法
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }
}
