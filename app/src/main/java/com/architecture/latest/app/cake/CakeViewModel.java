package com.architecture.latest.app.cake;

import android.arch.lifecycle.MutableLiveData;

import com.architecture.latest.app.interaction.model.ExistsLiveData;
import com.architecture.latest.app.PresenterViewModel;
import com.architecture.latest.system.entity.Cake;

import java.util.List;

class CakeViewModel extends PresenterViewModel {

    private ExistsLiveData<List<Cake>> cakes;
    private MutableLiveData<String> errorTitle;
    private MutableLiveData<String> errorBody;

    public CakeViewModel() {
        cakes = new ExistsLiveData<>();
        errorTitle = new MutableLiveData<>();
        errorBody = new MutableLiveData<>();
    }

    ExistsLiveData<List<Cake>> cakes() {
        return cakes;
    }

    MutableLiveData<String> errorTitle() {
        return errorTitle;
    }

    MutableLiveData<String> errorBody() {
        return errorBody;
    }
}