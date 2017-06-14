package com.memtrip.mvc.controller.app.cake;

import android.arch.lifecycle.MutableLiveData;

import com.memtrip.mvc.controller.UiViewModel;
import com.memtrip.mvc.controller.interaction.model.ErrorModel;
import com.memtrip.mvc.controller.interaction.model.ExistsLiveData;
import com.memtrip.mvc.system.entity.Cake;

import java.util.List;

class CakeViewModel extends UiViewModel {

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