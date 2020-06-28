package ru.vtb.internship;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.vtb.internship.entity.Member;
import ru.vtb.internship.entity.Tag;
import ru.vtb.internship.entity.Task;
import ru.vtb.internship.entity.Team;
import ru.vtb.internship.exceptions.ConverterException;
import ru.vtb.internship.utility.FileHelper;
import ru.vtb.internship.utility.UtilityJason;
import ru.vtb.internship.utility.UtilityXml;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainApp {

    private static final Logger log = LogManager.getRootLogger();
    private static final Pattern INPUT_TEMPLATE = Pattern.compile("(.*\\.(.+)) (.+)");
    private static final Map<String, Class> CLASSES;
    private final FileHelper fileHelper = new FileHelper();
    private final UtilityJason utilityJason = new UtilityJason();
    private final UtilityXml utilityXml = new UtilityXml();

    static {
        CLASSES = new HashMap<>();
        CLASSES.put("team", Team.class);
        CLASSES.put("tag", Tag.class);
        CLASSES.put("member", Member.class);
        CLASSES.put("task", Task.class);
    }

    public static void main(String[] args) {
        (new MainApp()).startApp(args);
    }

    private void startApp(String[] args) {
        for (String arg : args) {
            Matcher matcher = INPUT_TEMPLATE.matcher(arg);
            if (!matcher.find()) {
                log.debug("Wrong input : " + arg);
                continue;
            }
            Class cl = getClassSetting(matcher.group(3));
            Converter converter = getFunc(matcher.group(2));
            if (cl == null || converter == null) {
                continue;
            }
            log.info("Start convert : " + arg);
            converter.convert(matcher.group(1), cl);
        }
    }

    private Converter getFunc(String type) {
        switch (type) {
            case "xml":
                return this::xmlFileConvert;
            case "json":
                return this::jsonFileConvert;
        }
        log.debug("Invalid file format : " + type);
        return null;
    }

    private Class getClassSetting(String group) {
        Class cl = CLASSES.get(group);
        if (cl == null) {
            log.debug("Invalid class : " + group);
        }
        return cl;
    }

    private <T> void xmlFileConvert(String fileName, Class<T> cl) {
        try {
            String fileText = fileHelper.getFileContent(fileName);
            T obj = utilityXml.getObjectFromXml(fileText, cl);
            System.out.println(utilityXml.getXmlFromObject(obj, cl));
            System.out.println(utilityJason.getJsonFromObject(obj));
        } catch (ConverterException e) {
            log.warn(e);
            e.printStackTrace();
        }
    }

    private <T> void jsonFileConvert(String fileName, Class<T> cl) {
        try {
            String fileText = fileHelper.getFileContent(fileName);
            T obj = utilityJason.getObjectFromJson(fileText, cl);
            System.out.println(utilityXml.getXmlFromObject(obj, cl));
            System.out.println(utilityJason.getJsonFromObject(obj));
        } catch (ConverterException e) {
            log.warn(e);
            e.printStackTrace();
        }
    }
}
