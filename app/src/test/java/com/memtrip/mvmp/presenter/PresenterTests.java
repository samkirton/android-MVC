package com.memtrip.mvmp.presenter;

import com.memtrip.mvmp.repository.cake.MockCakeRepositoryModule;
import com.memtrip.mvmp.system.MockRxModule;

import org.mockito.MockitoAnnotations;

public class PresenterTests {

    protected MockRxModule rxModule;

    protected MockCakeRepositoryModule cakeRepositoryModule;

    public PresenterTests() {

        MockitoAnnotations.initMocks(this);

        rxModule = new MockRxModule();
        MockitoAnnotations.initMocks(rxModule);

        cakeRepositoryModule = new MockCakeRepositoryModule();
        MockitoAnnotations.initMocks(cakeRepositoryModule);
    }
}