package ru.vtb.internship.jackson.entity;

public class Tag {
    private long id;
    private String name;

    public Tag() {

    }

    public Tag(long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return String.format("[id = %d, name = %s]", id, name);
    }
}
