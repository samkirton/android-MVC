package com.architecture.latest.repository.cake.api;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface CakeApi {

    @GET("6c48e1595fb57bed78f2152790b1521e/raw/594dd98f5d93afb0e8e62c2be766536250623b1f/cakes.json")
    Single<List<CakeModel>> cakes();
}
