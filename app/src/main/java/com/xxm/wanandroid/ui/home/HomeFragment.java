package com.xxm.wanandroid.ui.home;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.xxm.wanandroid.R;
import com.xxm.wanandroid.base.BaseFragment;
import com.xxm.wanandroid.http.http.NetWorkManager;
import com.xxm.wanandroid.http.http.Request;
import com.xxm.wanandroid.model.ArticleModel;
import com.xxm.wanandroid.ui.home.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 首页
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {

    private static final String TAG = HomeFragment.class.getSimpleName();
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private int mCurrentPageNum;

    private HomeAdapter mAdapter;
    private List<ArticleModel.Article> mData = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    protected View onInflaterContent(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mSwipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity, LinearLayoutManager.VERTICAL));
        mSwipeRefreshLayout.setColorSchemeColors(Color.parseColor("#FF4081"), Color.parseColor("#303F9F"));
        //设置下拉刷新监听
        mSwipeRefreshLayout.setOnRefreshListener(() -> loadData(0));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new HomeAdapter(mActivity, mData);
        mRecyclerView.setAdapter(mAdapter);

        loadData(mCurrentPageNum);
    }

    private void loadData(int pageNum) {
        showLoading();
        Request request = NetWorkManager.getRequest();

        // 2. 采用Observable<...>形式对网络请求进行封装
        Observable<ArticleModel> observable = request.homeTree(pageNum);

        // 3. 发送网络请求(异步)
        observable.subscribeOn(Schedulers.io())               // 在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())  // 回到主线程 处理请求结果
                .subscribe(new Observer<ArticleModel>() {
                    // 发送请求后调用该复写方法（无论请求成功与否）

                    @Override
                    public void onSubscribe(Disposable d) {
                        // 初始化工作
                        Log.d(TAG, "onSubscribe 初始化工作");
                    }

                    // 发送请求成功后调用该复写方法
                    @Override
                    public void onNext(ArticleModel articleModel) {
                        // 对返回结果Translation类对象进行处理
                        Log.d(TAG, "onNext:" + articleModel.toString());
                        if (articleModel.getErrorCode() == 0) {
                            mData.clear();
                            mData.addAll(articleModel.getData().getDatas());
                            mAdapter.notifyDataSetChanged();
                        }

                    }

                    // 发送请求成功后，先调用onNext（）再调用该复写方法
                    @Override
                    public void onComplete() {
                        Log.d(TAG, "请求成功");
                        showLoadSuccess();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }

                    // 发送请求失败后调用该复写方法
                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "请求失败");
                        showLoadFailed();
                        mSwipeRefreshLayout.setRefreshing(false);
                        e.printStackTrace();

                    }
                });
    }

    @Override
    protected void onLoadRetry() {
        super.onLoadRetry();
        loadData(mCurrentPageNum);
    }
}
