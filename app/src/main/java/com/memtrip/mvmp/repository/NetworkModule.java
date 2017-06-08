package com.memtrip.mvmp.repository;

import android.content.Context;

import com.memtrip.mvmp.R;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class NetworkModule {

    private final Context context;

    public NetworkModule(Context context) {
        this.context = context;
    }

    @Provides
    OkHttpClient okHttpClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        int timeout = context.getResources().getInteger(R.integer.app_server_timeout);

        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper;
    }

    @Provides
    retrofit2.Converter.Factory converterFactory(ObjectMapper mapper) {
        return JacksonConverterFactory.create(mapper);
    }

    @Provides
    Retrofit retrofit(@Named("apiEndpoint") String endpoint,
                      OkHttpClient client,
                      retrofit2.Converter.Factory converterFactory) {

        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .client(client)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}