package com.memtrip.mvc.controller.interaction.model;

import android.arch.lifecycle.MutableLiveData;

public class ExistsLiveData<T> extends MutableLiveData<T> {

    private boolean exists;

    public boolean exists() {
        return exists;
    }

    @Override
    public void setValue(T value) {
        super.setValue(value);

        exists = true;
    }

    @Override
    public void postValue(T value) {
        super.postValue(value);

        exists = true;
    }
}
