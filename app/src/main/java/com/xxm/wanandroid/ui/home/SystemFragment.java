package com.xxm.wanandroid.ui.home;


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

import com.xxm.wanandroid.R;
import com.xxm.wanandroid.base.BaseFragment;
import com.xxm.wanandroid.http.APIService;
import com.xxm.wanandroid.model.SystemTreeData;
import com.xxm.wanandroid.model.SystemTreeModel;
import com.xxm.wanandroid.ui.home.adapter.SystemAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 体系
 * A simple {@link Fragment} subclass.
 * Use the {@link SystemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SystemFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final String TAG = SystemFragment.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private SystemAdapter mAdapter;
    private List<SystemTreeData> mData = new ArrayList<>();


    public SystemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SystemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SystemFragment newInstance(String param1, String param2) {
        SystemFragment fragment = new SystemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    protected View onInflaterContent(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_system, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity, LinearLayoutManager.VERTICAL));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new SystemAdapter(mActivity, mData);
        mRecyclerView.setAdapter(mAdapter);

        loadData("https://www.wanandroid.com/");
    }

    private void loadData(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        APIService request = retrofit.create(APIService.class);
        // 2. 采用Observable<...>形式对网络请求进行封装
        Observable<SystemTreeModel> observable = request.systemTree();

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
                    public void onNext(SystemTreeModel systemTreeModel) {
                        // 对返回结果Translation类对象进行处理
                        Log.d(TAG, "onNext:" + systemTreeModel.toString());
                        if (systemTreeModel.getErrorCode() == 0) {
                            mData.clear();
                            mData.addAll(systemTreeModel.getData());
                            mAdapter.notifyDataSetChanged();
                        }

                    }

                    // 发送请求成功后，先调用onNext（）再调用该复写方法
                    @Override
                    public void onComplete() {
                        Log.d(TAG, "请求成功");
                    }

                    // 发送请求失败后调用该复写方法
                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "请求失败");
                    }
                });
    }


}
