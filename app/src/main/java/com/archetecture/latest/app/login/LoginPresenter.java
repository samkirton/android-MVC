package com.archetecture.latest.app.login;

import com.archetecture.latest.R;
import com.archetecture.latest.app.Presenter;
import com.archetecture.latest.app.interaction.ViewClick;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class LoginPresenter extends Presenter<LoginViewModel, LoginView> {

    public LoginPresenter(LoginViewModel viewModel, LoginView view) {
        super(viewModel, view);
    }

    @Override
    protected void onStart() {
        System.currentTimeMillis();
    }

    @Override
    protected void onStop() {
        System.currentTimeMillis();
    }

    private void cta() {
        viewModel().setTest("works...!");
    }

    @Override
    public Consumer<ViewClick> click() {
        return new Consumer<ViewClick>() {
            @Override
            public void accept(@NonNull ViewClick viewClick) {
                switch (viewClick.id()) {
                    case R.id.login_activity_cta:
                        cta();
                        break;
                }
            }
        };
    }
}