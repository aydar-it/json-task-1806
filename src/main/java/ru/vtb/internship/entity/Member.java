package ru.vtb.internship.entity;

import com.fasterxml.jackson.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@XmlRootElement
@XmlType(propOrder = {"id", "name", "tasks"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"id", "name", "tasks"})
public class Member {
    @JsonAlias({"ID", "Id"})
    private long id;
    @JsonAlias({"Name", "NAME"})
    private String name;
    private List<Task> tasks;
    private final Map<String, Object> properties = new HashMap<>();

    @JsonIgnore
    private static final Logger log = LogManager.getLogger(Team.class);

    public Member() {
    }

    @JsonCreator
    public Member(
            @JsonProperty("id") long id,
            @JsonProperty("name") String name,
            @JsonProperty("tasks") List<Task> tasks) {
        if (name == null || tasks == null) {
            log.warn("Created new member with null : name = " + name + " tasks = " + tasks);
        }
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    @JsonAnySetter
    public void setProperties(String fieldName, Object value) {
        properties.put(fieldName, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return properties;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @XmlElementWrapper(name = "tasks")
    @XmlElement(name = "task")
    public List<Task> getTasks() {
        return tasks;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name == null) {
            log.warn("Member->name set to null");
        }
        this.name = name;
    }

    public void setTasks(List<Task> tasks) {
        if (name == null) {
            log.warn("Member->tasks set to null");
        }
        this.tasks = tasks;
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
