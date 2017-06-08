package com.memtrip.mvmp.presenter.app.cake;

import com.memtrip.mvmp.presenter.PresenterComponent;
import com.memtrip.mvmp.repository.NetworkModule;
import com.memtrip.mvmp.repository.cake.CakeRepositoryModule;
import com.memtrip.mvmp.repository.cake.api.CakeApiModule;
import com.memtrip.mvmp.system.RxModule;

import dagger.Component;

@Component(modules = {
        RxModule.class,
        NetworkModule.class,
        CakeApiModule.class,
        CakeRepositoryModule.class

})
public interface CakeComponent extends PresenterComponent {

    String CAKE_COMPONENT = "CAKE_COMPONENT";

    void inject(CakePresenter presenter);
}