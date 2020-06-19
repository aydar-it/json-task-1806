package ru.vtb.internship.jackson.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Objects;

public class Team {
    @JsonIgnore
    private long id;
    private String name;
    private List<Member> members;

    public Team() {
    }

    public Team(long id, String name, List<Member> members) {
        if (name == null || members == null) {
            throw new RuntimeException("Name and members can't be null!");
        }
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonGetter("name")
    public String getTheName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public List<? extends Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        if (members != null) {
            this.members = members;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id &&
                Objects.equals(name, team.name) &&
                Objects.equals(members, team.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, members);
    }
}
