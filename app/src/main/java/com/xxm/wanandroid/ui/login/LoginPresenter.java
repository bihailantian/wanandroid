package com.xxm.wanandroid.ui.login;

/**
 * 登陆插拔器
 */
public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void onUsernameError() {

    }

    @Override
    public void onPasswordError() {

    }

    @Override
    public void onSuccess() {

    }
}
