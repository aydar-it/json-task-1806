package ru.vtb.internship.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.vtb.internship.jackson.entity.Member;
import ru.vtb.internship.jackson.entity.Tag;
import ru.vtb.internship.jackson.entity.Task;
import ru.vtb.internship.jackson.entity.Team;
import ru.vtb.internship.jackson.utility.FileHelper;
import ru.vtb.internship.jackson.utility.UtilityJason;
import ru.vtb.internship.jackson.utility.UtilityXml;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainApp {
    public static void main(String[] args) {
        startApp(args);
    }

    private static void startApp(String[] args) {
        Pattern pattern = Pattern.compile("(.*.(xml|json)) (member|tag|task|team)");
        for (String fileName : args) {
            Matcher matcher = pattern.matcher(fileName);
            if (!matcher.find()) {
                System.out.println("Wrong argument : " + fileName);
                continue;
            }
            String type = matcher.group(2);
            Class cl = getClassSetting(matcher.group(3));
            switch (type) {
                case "xml":
                    xmlFileConvert(matcher.group(1), cl);
                    break;
                case "json":
                    jsonFileConvert(matcher.group(1), cl);
                    break;
            }
        }
    }

    private static Class getClassSetting(String group) {
        return group.equals("team") ? Team.class :
                group.equals("task") ? Task.class :
                group.equals("member") ? Member.class :
                Tag.class;
    }

    private static <T> void xmlFileConvert(String fileName, Class<T> cl) {
        try {
            String fileText = FileHelper.getFileContent(fileName);
            T obj = UtilityXml.getObjectFromXml(fileText, cl);
            System.out.println(UtilityXml.getXmlFromObject(obj, cl));
            System.out.println(UtilityJason.getJsonFromObject(obj));
        } catch (JAXBException | JsonProcessingException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static <T> void jsonFileConvert(String fileName, Class<T> cl) {
        try {
            String fileText = FileHelper.getFileContent(fileName);
            T obj = UtilityJason.getObjectFromJson(fileText, cl);
            System.out.println(UtilityXml.getXmlFromObject(obj, cl));
            System.out.println(UtilityJason.getJsonFromObject(obj));
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void showJsonExamples() {

        try {
            String jsonTag = FileHelper.getFileContent("src\\main\\resources\\json\\in\\tag.json");
            Tag tag = UtilityJason.getObjectFromJson(jsonTag, Tag.class);
            System.out.println(UtilityJason.getJsonFromObject(tag));

            String jsonTag2 = FileHelper.getFileContent("src\\main\\resources\\json\\in\\tag2.json");
            Tag tag2 = UtilityJason.getObjectFromJson(jsonTag2, Tag.class);
            System.out.println(UtilityJason.getJsonFromObject(tag2));

            String jsonTask = FileHelper.getFileContent("src\\main\\resources\\json\\in\\task.json");
            Task task = UtilityJason.getObjectFromJson(jsonTask, Task.class);
            System.out.println(UtilityJason.getJsonFromObject(task));

            String jsonMember = FileHelper.getFileContent("src\\main\\resources\\json\\in\\member.json");
            Member member = UtilityJason.getObjectFromJson(jsonMember, Member.class);
            System.out.println(UtilityJason.getJsonFromObject(member));

            String jsonTeam = FileHelper.getFileContent("src\\main\\resources\\json\\in\\team.json");
            Team team = UtilityJason.getObjectFromJson(jsonTeam, Team.class);
            System.out.println(UtilityJason.getJsonFromObject(team));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showXmlExamples() {
        try {
            String origTag = FileHelper.getFileContent("src\\main\\resources\\xml\\in\\tag.xml");
            Tag tag = UtilityXml.getObjectFromXml(origTag, Tag.class);
            System.out.println(UtilityXml.getXmlFromObject(tag, Tag.class));

            String origTeam = FileHelper.getFileContent("src\\main\\resources\\xml\\in\\team.xml");
            Team team = UtilityXml.getObjectFromXml(origTeam, Team.class);
            System.out.println(UtilityXml.getXmlFromObject(team, Team.class));

            String origMember = FileHelper.getFileContent("src\\main\\resources\\xml\\in\\member.xml");
            Member member = UtilityXml.getObjectFromXml(origMember, Member.class);
            System.out.println(UtilityXml.getXmlFromObject(member, Member.class));
        } catch (FileNotFoundException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
