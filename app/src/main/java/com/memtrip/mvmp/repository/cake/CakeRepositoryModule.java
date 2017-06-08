package com.memtrip.mvmp.repository.cake;

import com.memtrip.mvmp.repository.cake.api.CakeApi;
import com.memtrip.mvmp.repository.cake.api.CakeModel;
import com.memtrip.mvmp.system.entity.Cake;
import com.memtrip.mvmp.system.entity.convert.ConvertTo;

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