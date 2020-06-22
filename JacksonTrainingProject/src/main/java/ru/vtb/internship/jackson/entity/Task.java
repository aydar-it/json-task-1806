package ru.vtb.internship.jackson.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "task")
@XmlType(propOrder = {"id", "name", "tags"})
@JsonPropertyOrder({"id", "name", "tags"})
public class Task {
    private String name;
    private long id;
    private List<Tag> tags;

    public Task() {
    }

    public Task(String name, long id, List<Tag> tags) {
        if (name == null || tags == null) {
            throw new RuntimeException("Name and tags can't be null!");
        }
        this.name = name;
        this.id = id;
        this.tags = tags;
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

    @XmlElementWrapper(name = "tags")
    @XmlElement(name = "tag")
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        if (tags != null) {
            this.tags = tags;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(name, task.name) &&
                Objects.equals(tags, task.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, tags);
    }
}
