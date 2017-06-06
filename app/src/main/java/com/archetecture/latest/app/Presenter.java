package com.archetecture.latest.app;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

public abstract class Presenter<V extends PresenterView> implements LifecycleObserver {

    private final V view;

    public V view() {
        return view;
    }

    public Presenter(V view) {
        this.view = view;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop() {

    }
}