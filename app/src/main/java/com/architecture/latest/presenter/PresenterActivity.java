package com.architecture.latest.presenter;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.architecture.latest.presenter.interaction.DefaultViewClick;
import com.architecture.latest.presenter.interaction.ViewClick;
import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public abstract class PresenterActivity<V extends ViewModel, P extends Presenter, CP extends PresenterComponent>
        extends LifecycleActivity {

    private V viewModel;

    private P presenter;

    @SuppressWarnings("unchecked")
    protected CP injector(String name) {
        return (CP) getApplication().getSystemService(name);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(viewModel());

        presenter = createPresenter(viewModel);

        getLifecycle().addObserver(presenter);
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
        }).subscribe(presenter.click());
    }

    protected abstract P createPresenter(V viewModel);

    protected abstract Class<V> viewModel();
}