package com.memtrip.mvmp.presenter.interaction.model;

import com.memtrip.mvmp.presenter.interaction.model.res.StringResData;

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

    @Override
    public boolean equals(Object o) {
        if (o instanceof ErrorModel) {
            ErrorModel that = (ErrorModel) o;

            return title.equals(that.title)
                    && body.equals(that.body);
        } else {
            return false;
        }
    }
}