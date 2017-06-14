package com.memtrip.mvc.controller;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public abstract class UiViewModel extends ViewModel {

    private MutableLiveData<Boolean> showProgress;

    protected UiViewModel() {
        showProgress = new MutableLiveData<>();
    }

    public MutableLiveData<Boolean> showProgress() {
        return showProgress;
    }
}