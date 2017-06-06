package com.archetecture.latest.app.login;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;

import com.archetecture.latest.app.Presenter;
import com.archetecture.latest.app.PresenterView;

public class LoginPresenter extends Presenter<PresenterView> {

    public LoginPresenter(PresenterView view) {
        super(view);
    }

    protected void onStart() {
        System.currentTimeMillis();
    }

    protected void onStop() {
        System.currentTimeMillis();
    }
}