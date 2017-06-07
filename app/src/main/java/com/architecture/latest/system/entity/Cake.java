package com.architecture.latest.system.entity;

public class Cake {

    private final String title;
    private final String description;

    public String title() {
        return title;
    }

    public String desc() {
        return description;
    }

    public Cake(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
