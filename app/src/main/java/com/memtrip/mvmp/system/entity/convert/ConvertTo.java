package com.memtrip.mvmp.system.entity.convert;

public interface ConvertTo<M, E> {

    E from(M model);
}
