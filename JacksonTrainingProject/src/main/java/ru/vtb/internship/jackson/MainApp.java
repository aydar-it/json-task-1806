package ru.vtb.internship.jackson;

import ru.vtb.internship.jackson.entity.Member;
import ru.vtb.internship.jackson.entity.Tag;
import ru.vtb.internship.jackson.entity.Task;
import ru.vtb.internship.jackson.entity.Team;
import ru.vtb.internship.jackson.utility.UtilityJason;

public class MainApp {
    public static void main(String[] args) throws Exception{
        MainApp.showExamples();
    }

    public static void showExamples() throws Exception {
        String jsonTag = "{\"id\" : 2, \"name\" : \"java\"}";
        String jsonTag2 = "{\"id\" : 3, \"name\" : \"vagrant\"}";
        Tag tag = UtilityJason.getObjectFromText(jsonTag, Tag.class);
        System.out.println(UtilityJason.getTextFromObject(tag));
        Tag tag2 = UtilityJason.getObjectFromText(jsonTag2, Tag.class);
        System.out.println(UtilityJason.getTextFromObject(tag2));

        String jsonTask = "{\"id\" : 2, \"name\" : \"Read manual\", \"tags\" : [{\"id\" : 2, \"name\" : \"java\"}, {\"id\" : 3, \"name\" : \"vagrant\"}]}";
        String jsonTask2 = "{\"id\" : 1, \"name\" : \"Create new git account\", \"tags\" : [{\"id\" : 2, \"name\" : \"java\"}]}";
        Task task = UtilityJason.getObjectFromText(jsonTask, Task.class);
        System.out.println(UtilityJason.getTextFromObject(task));
        Task task2 = UtilityJason.getObjectFromText(jsonTask2, Task.class);
        System.out.println(UtilityJason.getTextFromObject(task2));

        String jsonMember = "{\"id\":10, \"name\":\"Ivan\", \"tasks\":[{\"id\" : 1, \"name\" : \"Create new git account\", \"tags\" : [{\"id\" : 2, \"name\" : \"java\"}]}]}";
        Member member = UtilityJason.getObjectFromText(jsonMember, Member.class);
        System.out.println(UtilityJason.getTextFromObject(member));

        String jsonTeam = "{\"id\":18, \"name\":\"Winners\", \"members\" : [{\"id\":10, \"name\":\"Ivan\", \"tasks\":[{\"id\" : 1, \"name\" : \"Create new git account\", \"tags\" : [{\"id\" : 2, \"name\" : \"java\"}]}]}, {\"id\":6, \"name\":\"Petya\", \"tasks\":[{\"id\" : 1, \"name\" : \"Create new git account\", \"tags\" : [{\"id\" : 2, \"name\" : \"java\"}]}]}]}]}";
        Team team = UtilityJason.getObjectFromText(jsonTeam, Team.class);
        System.out.println(UtilityJason.getTextFromObject(team));
    }
}
