package com.memtrip.mvc.repository.cake.api;

import com.memtrip.mvc.system.entity.Cake;
import com.memtrip.mvc.system.entity.convert.ConvertTo;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class CakeApiModule {

    @Provides
    @Named("apiEndpoint")
    String endPoint() {
        return "https://gist.githubusercontent.com/samkirton/";
    }

    @Provides
    CakeApi weatherApi(Retrofit retrofit) {
        return retrofit.create(CakeApi.class);
    }

    @Provides
    ConvertTo<List<CakeModel>, List<Cake>> convertToCake() {
        return new ConvertToCake();
    }
}