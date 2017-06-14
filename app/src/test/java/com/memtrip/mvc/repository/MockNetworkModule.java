package com.memtrip.mvc.repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.mockito.Mock;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class MockNetworkModule {

    @Mock
    OkHttpClient okHttpClient;

    @Mock
    ObjectMapper objectMapper;

    @Mock
    retrofit2.Converter.Factory converter;

    @Mock
    Retrofit retrofit;

    @Provides
    OkHttpClient okHttpClient() {
        return okHttpClient;
    }

    @Provides
    ObjectMapper objectMapper() {
        return objectMapper;
    }

    @Provides
    retrofit2.Converter.Factory converterFactory() {
        return converter;
    }

    @Provides
    Retrofit retrofit() {
        return retrofit;
    }
}
