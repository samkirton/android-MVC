package com.archetecture.latest.app;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;

import com.archetecture.latest.app.interaction.ViewClick;

import io.reactivex.functions.Consumer;

public abstract class Presenter<VM extends ViewModel, V extends PresenterView> implements LifecycleObserver {

    private final VM viewModel;
    private final V view;

    public VM viewModel() {
        return viewModel;
    }

    public V view() {
        return view;
    }

    public Presenter(VM viewModel, V view) {
        this.viewModel = viewModel;
        this.view = view;
    }

    protected Consumer<ViewClick> click() {
        throw new IllegalStateException("");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop() {

    }
}