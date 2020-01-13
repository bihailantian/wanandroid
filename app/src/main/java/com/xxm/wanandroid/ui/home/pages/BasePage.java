package com.xxm.wanandroid.ui.home.pages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xxm.wanandroid.R;

public abstract class BasePage {

    private static final String TAG = "BasePage";

    protected Context mContext;
    public View mRootPage;
    protected RecyclerView mRecyclerView;

    public BasePage(Context mContext) {
        this.mContext = mContext;
        initView();
    }

    protected void initView() {
        mRootPage = LayoutInflater.from(mContext).inflate(getLayoutRes(), null);
        mRecyclerView = mRootPage.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

    }


    /**
     * 初始化数据
     */
    public void initData() {

    }

    protected abstract int getLayoutRes();
}
