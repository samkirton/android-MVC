package com.memtrip.mvc.controller;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.memtrip.mvc.controller.interaction.ViewClick;

import io.reactivex.functions.Consumer;

public abstract class Controller<M extends UiViewModel> implements LifecycleObserver {

    private final M viewModel;

    protected M viewModel() {
        return viewModel;
    }

    public Controller(M viewModel) {
        this.viewModel = viewModel;
    }

    protected Consumer<ViewClick> click() {
        throw new IllegalStateException("click() must be overridden by the controller to handle clicks");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop() {

    }
}