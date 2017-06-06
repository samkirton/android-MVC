package com.archetecture.latest.app;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class PresenterActivity<P extends Presenter> extends LifecycleActivity implements PresenterView {

    private P presenter;

    public P presenter() {
        return presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = createPresenter();

        getLifecycle().addObserver(presenter);
    }

    protected abstract P createPresenter();
}