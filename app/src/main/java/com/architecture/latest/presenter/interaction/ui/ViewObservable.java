package com.architecture.latest.presenter.interaction.ui;

import android.arch.lifecycle.Observer;

public interface ViewObservable<T> {

    public interface Ui {
        void present();
    }

    Observer<T> attach(Ui ui);
}