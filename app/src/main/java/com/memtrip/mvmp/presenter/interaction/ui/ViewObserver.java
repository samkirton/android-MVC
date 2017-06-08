package com.memtrip.mvmp.presenter.interaction.ui;

import android.arch.lifecycle.Observer;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

public abstract class ViewObserver<T> implements Observer<T> {

    private final Ui ui;

    public interface Ui {
        void present();
    }

    ViewObserver(Ui ui) {
        this.ui = ui;
    }

    @CallSuper
    public void onChanged(@Nullable T t) {
        if (ui != null) {
            ui.present();
        }
    }
}