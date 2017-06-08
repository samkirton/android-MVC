package com.memtrip.mvmp.system;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

@Module
public class MockRxModule {

    @Provides
    @Named("mainThread")
    public Scheduler mainThreadScheduler() {
        return Schedulers.trampoline();
    }

    @Provides
    @Named("background")
    public Scheduler backgroundScheduler() {
        return Schedulers.trampoline();
    }
}