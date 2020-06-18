package ru.vtb.internship.jackson.entity;

import java.util.List;

public class Task {
    private long id;
    private String name;
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
