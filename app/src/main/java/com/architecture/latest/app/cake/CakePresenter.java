package com.architecture.latest.app.cake;

import com.architecture.latest.R;
import com.architecture.latest.app.Presenter;
import com.architecture.latest.app.interaction.ViewClick;
import com.architecture.latest.repository.cake.CakeRepository;
import com.architecture.latest.system.entity.Cake;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

class CakePresenter extends Presenter<CakeViewModel> {

    @Inject
    CakeRepository cakeRepository;

    @Inject
    @Named("mainThread")
    Scheduler mainThread;

    @Inject
    @Named("background")
    Scheduler background;

    private Disposable disposable;

    CakePresenter(CakeViewModel viewModel) {
        super(viewModel);
    }

    @Override
    protected void onStart() {
        initialCakes();
    }

    private void initialCakes() {

        if (!viewModel().cakes().exists()) {

            viewModel().showProgress().setValue(true);

            cakeRepository.cakes()
                    .observeOn(mainThread)
                    .subscribeOn(background)
                    .subscribe(new SingleObserver<List<Cake>>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {
                            disposable = d;
                        }

                        @Override
                        public void onSuccess(@NonNull List<Cake> cakes) {
                            success(cakes);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            failure();
                        }
                    });
        }
    }

    private void success(List<Cake> cakes) {

        viewModel().showProgress().setValue(false);

        viewModel().cakes().setValue(cakes);
    }

    private void failure() {

        viewModel().showProgress().setValue(false);

        viewModel().errorTitle().setValue("works...!");
        viewModel().errorBody().setValue("works...!");
    }

    @Override
    protected void onStop() {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override
    public Consumer<ViewClick> click() {
        return new Consumer<ViewClick>() {
            @Override
            public void accept(@NonNull ViewClick viewClick) {
                switch (viewClick.id()) {
                    case R.id.cake_activity_error_retry:
                        initialCakes();
                        break;
                }
            }
        };
    }
}