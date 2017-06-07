package com.architecture.latest.app.interaction.ui;

import android.arch.lifecycle.Observer;

public interface ViewObservable<T> {

    Observer<T> attach();
}