package ru.vtb.internship.jackson.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "team")
@XmlType(propOrder = {"id", "name", "members"})
@JsonPropertyOrder({"id", "name", "members"})
public class Team {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    @XmlElementWrapper(name = "members")
    @XmlElement(name = "member")
    public List<Member> getMembers() {
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
