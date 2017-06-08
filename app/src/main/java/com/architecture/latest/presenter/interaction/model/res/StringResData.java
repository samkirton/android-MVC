package com.architecture.latest.presenter.interaction.model.res;

import android.support.annotation.StringRes;

public class StringResData {

    private final @StringRes int id;

    public @StringRes int id() {
        return id;
    }

    public StringResData(@StringRes int id) {
        this.id = id;
    }
}
