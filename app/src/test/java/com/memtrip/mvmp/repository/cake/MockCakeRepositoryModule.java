package com.memtrip.mvmp.repository.cake;

import org.mockito.Mock;

import dagger.Module;
import dagger.Provides;

@Module
public class MockCakeRepositoryModule {

    @Mock
    CakeRepository cakeRepository;

    @Provides
    public CakeRepository cakeRepository() {
        return cakeRepository;
    }
}