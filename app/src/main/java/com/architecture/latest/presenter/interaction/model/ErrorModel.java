package com.architecture.latest.presenter.interaction.model;

import com.architecture.latest.presenter.interaction.model.res.StringResData;

public class ErrorModel {

    private final StringResData title;
    private final StringResData body;

    public StringResData title() {
        return title;
    }

    public StringResData body() {
        return body;
    }

    public ErrorModel(StringResData title, StringResData body) {
        this.title = title;
        this.body = body;
    }
}