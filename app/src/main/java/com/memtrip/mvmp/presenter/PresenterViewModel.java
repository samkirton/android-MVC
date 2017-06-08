package com.memtrip.mvmp.presenter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class PresenterViewModel extends ViewModel {

    private MutableLiveData<Boolean> showProgress;

    protected PresenterViewModel() {
        showProgress = new MutableLiveData<>();
    }

    public MutableLiveData<Boolean> showProgress() {
        return showProgress;
    }
}