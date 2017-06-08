package com.architecture.latest.presenter;

import android.app.Application;

import com.architecture.latest.presenter.app.cake.CakeComponent;
import com.architecture.latest.presenter.app.cake.DaggerCakeComponent;
import com.architecture.latest.repository.NetworkModule;
import com.architecture.latest.repository.cake.CakeRepositoryModule;
import com.architecture.latest.repository.cake.api.CakeApiModule;
import com.architecture.latest.system.RxModule;

import static com.architecture.latest.presenter.app.cake.CakeComponent.CAKE_COMPONENT;

public class DefaultApplication extends Application {

    private CakeComponent cakeComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        cakeComponent = DaggerCakeComponent
                .builder()
                .rxModule(new RxModule())
                .networkModule(new NetworkModule(this))
                .cakeApiModule(new CakeApiModule())
                .cakeRepositoryModule(new CakeRepositoryModule())
                .build();
    }

    @Override
    public Object getSystemService(String name) {
        if (CAKE_COMPONENT.equals(name)) {
            return cakeComponent;
        } else {
            return super.getSystemService(name);
        }
    }
}
