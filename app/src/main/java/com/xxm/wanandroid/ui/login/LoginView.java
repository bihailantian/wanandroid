package com.xxm.wanandroid.ui.login;

public interface LoginView {
    /**
     * 显示进度条
     */
    void showProgress();

    /**
     * 隐藏进度条
     */
    void hideProgress();

    /**
     * 用户名错误
     */
    void setUsernameError();

    /**
     * 密码错误
     */
    void setPasswordError();

    /**
     * 导航到主页
     */
    void navigateToHome();
}
