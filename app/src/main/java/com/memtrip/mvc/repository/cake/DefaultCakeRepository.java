package com.memtrip.mvc.repository.cake;

import com.memtrip.mvc.repository.cake.api.CakeApi;
import com.memtrip.mvc.repository.cake.api.CakeModel;
import com.memtrip.mvc.system.entity.Cake;
import com.memtrip.mvc.system.entity.convert.ConvertTo;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

class DefaultCakeRepository implements CakeRepository {

    private final CakeApi cakeApi;
    private final ConvertTo<List<CakeModel>, List<Cake>> convertToCake;

    DefaultCakeRepository(CakeApi cakeApi, ConvertTo<List<CakeModel>, List<Cake>> convertToCake) {
        this.cakeApi = cakeApi;
        this.convertToCake = convertToCake;
    }

    @Override
    public Single<List<Cake>> cakes() {
        return cakesFromApi();
    }

    private Single<List<Cake>> cakesFromApi() {
        return cakeApi.cakes().flatMap(new Function<List<CakeModel>, SingleSource<List<Cake>>>() {
            @Override
            public SingleSource<List<Cake>> apply(final @NonNull List<CakeModel> cakeModels) {
                return new Single<List<Cake>>() {
                    @Override
                    protected void subscribeActual(@NonNull SingleObserver<? super List<Cake>> observer) {
                        observer.onSuccess(convertToCake.from(cakeModels));
                    }
                };
            }
        });
    }
}