package com.memtrip.mvc.controller;

import com.memtrip.mvc.repository.cake.MockCakeRepositoryModule;
import com.memtrip.mvc.system.MockRxModule;

import org.mockito.MockitoAnnotations;

public class ControllerTests {

    protected MockRxModule rxModule;

    protected MockCakeRepositoryModule cakeRepositoryModule;

    public ControllerTests() {

        MockitoAnnotations.initMocks(this);

        rxModule = new MockRxModule();
        MockitoAnnotations.initMocks(rxModule);

        cakeRepositoryModule = new MockCakeRepositoryModule();
        MockitoAnnotations.initMocks(cakeRepositoryModule);
    }
}