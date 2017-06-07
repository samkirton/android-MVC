package com.architecture.latest.system.entity.convert;

public interface ConvertTo<M, E> {

    E from(M model);
}
