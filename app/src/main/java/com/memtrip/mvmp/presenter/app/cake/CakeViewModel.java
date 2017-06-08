package com.memtrip.mvmp.presenter.app.cake;

import android.arch.lifecycle.MutableLiveData;

import com.memtrip.mvmp.presenter.PresenterViewModel;
import com.memtrip.mvmp.presenter.interaction.model.ErrorModel;
import com.memtrip.mvmp.presenter.interaction.model.ExistsLiveData;
import com.memtrip.mvmp.system.entity.Cake;

import java.util.List;

class CakeViewModel extends PresenterViewModel {

    private ExistsLiveData<List<Cake>> cakes;
    private MutableLiveData<ErrorModel> error;

    public CakeViewModel() {
        cakes = new ExistsLiveData<>();
        error = new MutableLiveData<>();
    }

    ExistsLiveData<List<Cake>> cakes() {
        return cakes;
    }

    MutableLiveData<ErrorModel> error() {
        return error;
    }
}