package com.architecture.latest.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.architecture.latest.presenter.interaction.ViewClick;

import io.reactivex.functions.Consumer;

public abstract class Presenter<M extends PresenterViewModel> implements LifecycleObserver {

    private final M viewModel;

    protected M viewModel() {
        return viewModel;
    }

    public Presenter(M viewModel) {
        this.viewModel = viewModel;
    }

    protected Consumer<ViewClick> click() {
        throw new IllegalStateException("click() must be overriden by the presenter to handle clicks");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop() {

    }
}