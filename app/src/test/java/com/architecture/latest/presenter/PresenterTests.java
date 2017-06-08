package com.architecture.latest.presenter;

import com.architecture.latest.repository.cake.MockCakeRepositoryModule;
import com.architecture.latest.system.MockRxModule;

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