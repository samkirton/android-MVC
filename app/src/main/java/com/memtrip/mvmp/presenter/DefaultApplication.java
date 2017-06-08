package com.memtrip.mvmp.presenter;

import android.app.Application;

import com.memtrip.mvmp.presenter.app.cake.CakeComponent;
import com.memtrip.mvmp.presenter.app.cake.DaggerCakeComponent;
import com.memtrip.mvmp.repository.NetworkModule;
import com.memtrip.mvmp.repository.cake.CakeRepositoryModule;
import com.memtrip.mvmp.repository.cake.api.CakeApiModule;
import com.memtrip.mvmp.system.RxModule;

import static com.memtrip.mvmp.presenter.app.cake.CakeComponent.CAKE_COMPONENT;

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
