package ru.vtb.internship.jackson.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Member {
    private long id;
    private String name;
    private List<Task> tasks;
    private Map<String, String> properties = new HashMap<>();

    public Member() {
    }

    public Member(long id, String name, List<Task> tasks, Map<String, String> properties) {
        if (name == null || tasks == null || properties == null) {
            throw new RuntimeException("Name, tasks and properties can't be null!");
        }
        this.id = id;
        this.name = name;
        this.tasks = tasks;
        this.properties = properties;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
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

    public List<? extends Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        if (tasks != null) {
            this.tasks = tasks;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id &&
                Objects.equals(name, member.name) &&
                Objects.equals(tasks, member.tasks) &&
                Objects.equals(properties, member.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tasks, properties);
    }
}
