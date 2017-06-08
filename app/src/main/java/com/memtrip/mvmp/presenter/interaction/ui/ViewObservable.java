package com.memtrip.mvmp.presenter.interaction.ui;

import android.arch.lifecycle.Observer;

public interface ViewObservable<T> {

    Observer<T> attach();
}