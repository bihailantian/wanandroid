package com.xxm.wanandroid.ui.home.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;


/**
 * Tablayout的适配器
 *
 * @author xuxiaoming
 * @date: 2017/10/16
 */
public class TablayoutAdapter extends FragmentPagerAdapter {

    private String[] mTitleList;
    private List<Fragment> mFragmentList;

    public TablayoutAdapter(FragmentManager fm, String[] titleList, List<Fragment> fragmentList) {
        super(fm);

        this.mTitleList = titleList;
        this.mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList != null ? mFragmentList.size() : 0;
    }


    //配置标题的方法
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList[position];
    }
}
