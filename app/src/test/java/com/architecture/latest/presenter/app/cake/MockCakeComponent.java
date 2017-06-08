package com.architecture.latest.presenter.app.cake;

import com.architecture.latest.presenter.PresenterComponent;
import com.architecture.latest.repository.cake.MockCakeRepositoryModule;
import com.architecture.latest.system.MockRxModule;

import dagger.Component;

@Component(modules = {
        MockRxModule.class,
        MockCakeRepositoryModule.class

})
public interface MockCakeComponent extends PresenterComponent {

    void inject(CakePresenter presenter);
}