package com.architecture.latest.repository.cake;

import com.architecture.latest.repository.cake.api.CakeApi;
import com.architecture.latest.repository.cake.api.CakeModel;
import com.architecture.latest.system.entity.Cake;
import com.architecture.latest.system.entity.convert.ConvertTo;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class CakeRepositoryModule {

    @Provides
    public CakeRepository cakeRepository(CakeApi cakeApi, ConvertTo<List<CakeModel>, List<Cake>> convertTo) {
        return new DefaultCakeRepository(cakeApi, convertTo);
    }
}