package com.architecture.latest.repository.cake;

import com.architecture.latest.system.entity.Cake;

import java.util.List;

import io.reactivex.Single;

public interface CakeRepository {

    Single<List<Cake>> cakes();
}