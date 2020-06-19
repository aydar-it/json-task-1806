package ru.vtb.internship.jackson;

import ru.vtb.internship.jackson.entity.Member;
import ru.vtb.internship.jackson.entity.Tag;
import ru.vtb.internship.jackson.entity.Task;
import ru.vtb.internship.jackson.entity.Team;
import ru.vtb.internship.jackson.utility.UtilityJason;

import java.util.Map;

public class MainApp {
    public static void main(String[] args) throws Exception{
        MainApp.showExamples();
    }

    public static void showExamples() throws Exception {
        String jsonTag = "{\"ID\" : 2, \"name\" : \"java\"}";
        String jsonTag2 = "{\"Id\" : 3, \"name\" : \"vagrant\"}";
        Tag tag = UtilityJason.getObjectFromJson(jsonTag, Tag.class);
        System.out.println(UtilityJason.getJsonFromObject(tag));
        Tag tag2 = UtilityJason.getObjectFromJson(jsonTag2, Tag.class);
        System.out.println(UtilityJason.getJsonFromObject(tag2));

        String jsonTask = "{\"id\" : 2, \"name\" : \"Read manual\", \"tags\" : [{\"id\" : 2, \"name\" : \"java\"}," +
                " {\"id\" : 3, \"name\" : \"vagrant\"}]}";
        String jsonTask2 = "{\"id\" : 1, \"name\" : \"Create new git account\", \"tags\" : [{\"id\" : 2, \"name\" : \"java\"}]}";
        Task task = UtilityJason.getObjectFromJson(jsonTask, Task.class);
        System.out.println(UtilityJason.getJsonFromObject(task));
        Task task2 = UtilityJason.getObjectFromJson(jsonTask2, Task.class);
        System.out.println(UtilityJason.getJsonFromObject(task2));

        String jsonMember = "{\"id\":10, \"name\":\"Ivan\", \"tasks\":[{\"id\" : 1, \"name\" : " +
                "\"Create new git account\", \"tags\" : [{\"id\" : 2, \"name\" : \"java\"}]}]}";
        Member member = UtilityJason.getObjectFromJson(jsonMember, Member.class);
        Map<String, String> map = member.getProperties();
        map.put("attr", "value");
        System.out.println(UtilityJason.getJsonFromObject(member));

        String jsonTeam = "{\"id\":18, \"name\":\"Winners\", \"members\" : [{\"id\":10, \"name\":\"Ivan\", " +
                "\"tasks\":[{\"id\" : 1, \"name\" : \"Create new git account\", \"tags\" : [{\"id\" : 2, \"name\" : " +
                "\"java\"}]}]}, {\"id\":6, \"name\":\"Petya\", \"tasks\":[{\"id\" : 1, \"name\" : \"Create new git " +
                "account\", \"tags\" : [{\"id\" : 2, \"name\" : \"java\"}]}]}]}]}";
        Team team = UtilityJason.getObjectFromJson(jsonTeam, Team.class);
        System.out.println(UtilityJason.getJsonFromObject(team));


    }
}
