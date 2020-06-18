package ru.vtb.internship.jackson.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"id", "name", "tags"})
public class Task {
    private String name;
    private long id;
    private List<Tag> tags;

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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        String a = String.format("[id = %d, name = %s, tags = ", id, name);
        for (Tag tag : tags) {
            a = a + tag.toString();
        }
        return a + "]";
    }
}
