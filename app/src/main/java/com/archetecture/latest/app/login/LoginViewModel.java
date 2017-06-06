package com.archetecture.latest.app.login;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

class LoginViewModel extends ViewModel {

    private MutableLiveData<String> test = new MutableLiveData<>();

    public MutableLiveData<String> test() {
        return test;
    }

    public void setTest(String value) {
        this.test.setValue(value);
    }
}