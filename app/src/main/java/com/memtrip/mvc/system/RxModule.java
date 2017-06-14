package com.memtrip.mvc.system;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class RxModule {

    @Provides
    @Named("mainThread")
    public Scheduler mainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Named("background")
    public Scheduler backgroundScheduler() {
        return Schedulers.io();
    }
}
