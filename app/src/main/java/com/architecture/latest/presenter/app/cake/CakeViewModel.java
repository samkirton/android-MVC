package com.architecture.latest.presenter.app.cake;

import android.arch.lifecycle.MutableLiveData;

import com.architecture.latest.presenter.interaction.model.ErrorModel;
import com.architecture.latest.presenter.interaction.model.ExistsLiveData;
import com.architecture.latest.presenter.PresenterViewModel;
import com.architecture.latest.system.entity.Cake;

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