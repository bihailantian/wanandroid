package com.xxm.wanandroid.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.billy.android.loading.Gloading;

public abstract class BaseFragment extends Fragment {
    public Activity mActivity;
    protected View mContainer;
    private Gloading.Holder mHolder;


    /**
     * make a Gloading.Holder wrap with current activity by default
     * override this method in subclass to do special initialization
     */
    protected void initLoadingStatusViewIfNeed() {
        if (mHolder == null) {
            mHolder = Gloading.getDefault().cover(mContainer).withRetry(this::onLoadRetry);
        }
    }

    protected void onLoadRetry() {
        // override this method in subclass to do retry task
    }

    public void showLoading() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoading();
    }

    public void showLoadSuccess() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoadSuccess();
    }

    public void showLoadFailed() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoadFailed();
    }

    public void showEmpty() {
        initLoadingStatusViewIfNeed();
        mHolder.showEmpty();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mContainer == null) {
            mContainer = onInflaterContent(inflater, container, savedInstanceState);
        }
        return mContainer;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mContainer != null) {
            ViewGroup parent = (ViewGroup) mContainer.getParent();
            if (parent != null) {
                parent.removeView(mContainer);
            }
        }
    }

    /**
     * 获取mContainer
     *
     * @return mContainer
     */
    public View getContainer() {
        return mContainer;
    }


    /**
     * Called to have the fragment instantiate its user interface view
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return Return the View for the fragment's UI
     */
    protected abstract View onInflaterContent(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected void initData(Bundle savedInstanceState) {
    }

    ;
}
