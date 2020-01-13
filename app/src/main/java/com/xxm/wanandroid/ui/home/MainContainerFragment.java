package com.xxm.wanandroid.ui.home;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xxm.wanandroid.R;
import com.xxm.wanandroid.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainContainerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainContainerFragment extends BaseFragment {


    private static final String TAG = MainContainerFragment.class.getSimpleName();

    private BaseFragment currentFragment;
    private OnFragmentInteractionListener mListener;

    public MainContainerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainContainerFragment.
     */
    public static MainContainerFragment newInstance() {
        return new MainContainerFragment();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitleText(R.string.wan_android);
                    switchFragment(HomeFragment.newInstance());
                    return true;
                case R.id.navigation_system:
                    setTitleText(R.string.title_system);
                    switchFragment(SystemFragment.newInstance());
                    return true;
                case R.id.navigation_public:
                    setTitleText(R.string.title_public);
                    switchFragment(PublicFragment.newInstance());
                    return true;

                case R.id.navigation_navigation:
                    setTitleText(R.string.title_navigation);
                    switchFragment(NavigationFragment.newInstance());
                    return true;

                case R.id.navigation_project:
                    setTitleText(R.string.title_project);
                    switchFragment(ProjectFragment.newInstance());
                    return true;
            }
            return false;
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleText(R.string.wan_android);
        switchFragment(HomeFragment.newInstance());

    }

    @Override
    protected View onInflaterContent(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_container, null);
        BottomNavigationView navView = view.findViewById(R.id.nav_view);
        //mTextMessage = view.findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //解决 BottomNavigationView 大于3个menu文字不显示 问题 关于item>3会有位移，这个在api28已经解决，
        // 在ButtomNavigationView添加app:labelVisibilityMode="labeled"就可以解决
        //navView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        return view;
    }

    private void switchFragment(BaseFragment targetFragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BaseFragment fragmentByTag = (BaseFragment) fragmentManager.findFragmentByTag(targetFragment.getClass().getName());
        if (fragmentByTag != null) {
            targetFragment = fragmentByTag;
        }
        if (!targetFragment.isAdded()) {
            Log.d(TAG, "第一次添加");
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                Log.d(TAG, "currentFragment 不为null");
                transaction.hide(currentFragment);
            }
            Log.d(TAG, "getName:" + targetFragment.getClass().getName());
            transaction.add(R.id.fl_content, targetFragment, targetFragment.getClass().getName());
        } else {
            Log.d(TAG, "不是第一次添加");
            transaction.hide(currentFragment).show(targetFragment);
        }
        currentFragment = targetFragment;
        transaction.commit();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void setTitleText(@StringRes int resId) {
        if (mListener != null)
            mListener.setTitleText(resId);
    }

    public interface OnFragmentInteractionListener {
        void setTitleText(String title);

        void setTitleText(@StringRes int resId);
    }
}
