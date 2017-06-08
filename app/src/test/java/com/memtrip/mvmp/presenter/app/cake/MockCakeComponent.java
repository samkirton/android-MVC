package com.memtrip.mvmp.presenter.app.cake;

import com.memtrip.mvmp.presenter.PresenterComponent;
import com.memtrip.mvmp.repository.cake.MockCakeRepositoryModule;
import com.memtrip.mvmp.system.MockRxModule;

import dagger.Component;

@Component(modules = {
        MockRxModule.class,
        MockCakeRepositoryModule.class

})
public interface MockCakeComponent extends PresenterComponent {

    void inject(CakePresenter presenter);
}