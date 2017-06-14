package com.memtrip.mvc.repository.cake;

import com.memtrip.mvc.repository.cake.api.CakeApi;
import com.memtrip.mvc.repository.cake.api.CakeModel;
import com.memtrip.mvc.system.entity.Cake;
import com.memtrip.mvc.system.entity.convert.ConvertTo;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class CakeRepositoryModule {

    @Provides
    CakeRepository cakeRepository(CakeApi cakeApi, ConvertTo<List<CakeModel>, List<Cake>> convertTo) {
        return new DefaultCakeRepository(cakeApi, convertTo);
    }
}