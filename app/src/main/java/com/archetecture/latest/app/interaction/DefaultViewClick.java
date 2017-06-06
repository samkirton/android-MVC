package com.archetecture.latest.app.interaction;

public class DefaultViewClick implements ViewClick {

    private final int id;

    public DefaultViewClick(int id) {
        this.id = id;
    }

    @Override
    public int id() {
        return id;
    }
}