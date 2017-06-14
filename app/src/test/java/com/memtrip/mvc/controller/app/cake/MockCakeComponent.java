package com.memtrip.mvc.controller.app.cake;

import com.memtrip.mvc.controller.ControllerComponent;
import com.memtrip.mvc.repository.cake.MockCakeRepositoryModule;
import com.memtrip.mvc.system.MockRxModule;

import dagger.Component;

@Component(modules = {
        MockRxModule.class,
        MockCakeRepositoryModule.class

})
public interface MockCakeComponent extends ControllerComponent {

    void inject(CakeController controller);
}