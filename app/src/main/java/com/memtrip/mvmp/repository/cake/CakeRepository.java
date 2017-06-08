package com.memtrip.mvmp.repository.cake;

import com.memtrip.mvmp.system.entity.Cake;

import java.util.List;

import io.reactivex.Single;

public interface CakeRepository {

    Single<List<Cake>> cakes();
}