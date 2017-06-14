package com.memtrip.mvc.repository.cake;

import com.memtrip.mvc.system.entity.Cake;

import java.util.List;

import io.reactivex.Single;

public interface CakeRepository {

    Single<List<Cake>> cakes();
}