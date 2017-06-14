package com.memtrip.mvc.controller.app.cake;

import com.memtrip.mvc.controller.ControllerComponent;
import com.memtrip.mvc.repository.NetworkModule;
import com.memtrip.mvc.repository.cake.CakeRepositoryModule;
import com.memtrip.mvc.repository.cake.api.CakeApiModule;
import com.memtrip.mvc.system.RxModule;

import dagger.Component;

@Component(modules = {
        RxModule.class,
        NetworkModule.class,
        CakeApiModule.class,
        CakeRepositoryModule.class

})
public interface CakeComponent extends ControllerComponent {

    String CAKE_COMPONENT = "CAKE_COMPONENT";

    void inject(CakeController controller);
}