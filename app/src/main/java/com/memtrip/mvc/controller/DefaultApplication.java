package com.memtrip.mvc.controller;

import android.app.Application;

import com.memtrip.mvc.controller.app.cake.CakeComponent;
import com.memtrip.mvc.controller.app.cake.DaggerCakeComponent;
import com.memtrip.mvc.repository.NetworkModule;
import com.memtrip.mvc.repository.cake.CakeRepositoryModule;
import com.memtrip.mvc.repository.cake.api.CakeApiModule;
import com.memtrip.mvc.system.RxModule;

import static com.memtrip.mvc.controller.app.cake.CakeComponent.CAKE_COMPONENT;

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
