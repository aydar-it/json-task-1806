package ru.vtb.internship.jackson.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Tag {
    @JsonAlias({"ID", "Id", "id"})
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
