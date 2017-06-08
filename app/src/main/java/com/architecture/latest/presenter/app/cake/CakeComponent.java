package com.architecture.latest.presenter.app.cake;

import com.architecture.latest.presenter.PresenterComponent;
import com.architecture.latest.repository.NetworkModule;
import com.architecture.latest.repository.cake.CakeRepositoryModule;
import com.architecture.latest.repository.cake.api.CakeApiModule;
import com.architecture.latest.system.RxModule;

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