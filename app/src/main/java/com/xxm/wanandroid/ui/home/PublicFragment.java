package com.xxm.wanandroid.ui.home;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.xxm.wanandroid.R;
import com.xxm.wanandroid.base.BaseFragment;
import com.xxm.wanandroid.http.http.NetWorkManager;
import com.xxm.wanandroid.http.http.Request;
import com.xxm.wanandroid.model.SystemTreeData;
import com.xxm.wanandroid.model.SystemTreeModel;
import com.xxm.wanandroid.ui.home.adapter.PageViewAdapter;
import com.xxm.wanandroid.ui.home.pages.BasePage;
import com.xxm.wanandroid.ui.home.pages.PublicPage;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 公众号
 * A simple {@link Fragment} subclass.
 * Use the {@link PublicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PublicFragment extends BaseFragment {


    private static final String TAG = PublicFragment.class.getSimpleName();
    private TabLayout mTabs;
    private ViewPager vpPager;

    private List<BasePage> pageList = new ArrayList<>();
    private List<String> mTitleList = new ArrayList<>();
    private PageViewAdapter adapter;

    public PublicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PublicFragment.
     */

    public static PublicFragment newInstance() {
        return new PublicFragment();
    }


    @Override
    protected View onInflaterContent(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_public, container, false);
        mTabs = view.findViewById(R.id.tabs);
        vpPager = view.findViewById(R.id.vp_pager);
        return view;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        if (adapter == null) {
            adapter = new PageViewAdapter(pageList, mTitleList);
            mTabs.setTabMode(TabLayout.MODE_SCROLLABLE);  //MODE_SCROLLABLE tab的个数多的时候用
            mTabs.setupWithViewPager(vpPager);
        }
        vpPager.setAdapter(adapter);
        loadData();

    }

    private void loadData() {
        showLoading();
        Request request = NetWorkManager.getRequest();

        // 2. 采用Observable<...>形式对网络请求进行封装
        Observable<SystemTreeModel> observable = request.wxList();

        // 3. 发送网络请求(异步)
        observable.subscribeOn(Schedulers.io())               // 在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())  // 回到主线程 处理请求结果
                .subscribe(new Observer<SystemTreeModel>() {
                    // 发送请求后调用该复写方法（无论请求成功与否）

                    @Override
                    public void onSubscribe(Disposable d) {
                        // 初始化工作
                        Log.d(TAG, "onSubscribe 初始化工作");
                    }

                    // 发送请求成功后调用该复写方法
                    @Override
                    public void onNext(SystemTreeModel treeModel) {
                        // 对返回结果Translation类对象进行处理
                        Log.d(TAG, "onNext:" + treeModel.toString());

                        pageList.clear();
                        List<SystemTreeData> data = treeModel.getData();
                        if (data != null) {
                            for (SystemTreeData treeData : data) {
                                PublicPage page = new PublicPage(mActivity);
                                page.setText(treeData.getName());
                                mTitleList.add(treeData.getName());
                                pageList.add(page);
                            }
                        }
                        if (adapter != null)
                            adapter.notifyDataSetChanged();


                    }

                    // 发送请求成功后，先调用onNext（）再调用该复写方法
                    @Override
                    public void onComplete() {
                        Log.d(TAG, "请求成功");
                        showLoadSuccess();

                    }

                    // 发送请求失败后调用该复写方法
                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "请求失败");
                        showLoadFailed();
                        e.printStackTrace();

                    }
                });
    }

}
