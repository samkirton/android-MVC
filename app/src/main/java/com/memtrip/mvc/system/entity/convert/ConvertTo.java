package com.memtrip.mvc.system.entity.convert;

public interface ConvertTo<M, E> {

    E from(M model);
}
