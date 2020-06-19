package ru.vtb.internship.jackson.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Objects;

public class Tag {
    @JsonAlias({"ID", "Id", "id"})
    private long id;
    private String name;

    public Tag() {
    }

    public Tag(long id, String name) {
        if (name == null) {
            throw new RuntimeException("Name can't be null");
        }
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
        if (name != null) {
            this.name = name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return id == tag.id &&
                Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
