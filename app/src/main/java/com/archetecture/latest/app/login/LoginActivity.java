package com.archetecture.latest.app.login;

import com.archetecture.latest.app.PresenterActivity;

public class LoginActivity extends PresenterActivity<LoginPresenter> implements LoginView {

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }
}
