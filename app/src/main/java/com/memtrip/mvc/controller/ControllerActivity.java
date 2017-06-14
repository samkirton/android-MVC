package com.memtrip.mvc.controller;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;
import com.memtrip.mvc.controller.interaction.DefaultViewClick;
import com.memtrip.mvc.controller.interaction.ViewClick;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public abstract class ControllerActivity<V extends ViewModel, C extends Controller, DI extends ControllerComponent>
        extends LifecycleActivity {

    private V viewModel;

    private C controller;

    @SuppressWarnings("unchecked")
    protected DI injector(String name) {
        return (DI) getApplication().getSystemService(name);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(viewModel());

        controller = createController(viewModel);

        getLifecycle().addObserver(controller);
    }

    @Override
    protected void onStart() {
        super.onStart();

        observe(viewModel);
    }

    protected void observe(V viewModel) {

    }

    protected void observeClicks(View ... views) {
        for (View view : views) {
            observeClicks(view);
        }
    }

    protected void observeClicks(final View view) {
        RxView.clicks(view).flatMap(new Function<Object, ObservableSource<ViewClick>>() {
            @Override
            public ObservableSource<ViewClick> apply(@NonNull Object o) throws Exception {
                return new ObservableSource<ViewClick>() {
                    @Override
                    public void subscribe(@NonNull Observer<? super ViewClick> observer) {
                        observer.onNext(new DefaultViewClick(view.getId()));
                    }
                };
            }
        }).subscribe(controller.click());
    }

    protected abstract C createController(V viewModel);

    protected abstract Class<V> viewModel();
}