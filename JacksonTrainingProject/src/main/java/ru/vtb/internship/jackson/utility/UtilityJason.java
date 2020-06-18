package ru.vtb.internship.jackson.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.vtb.internship.jackson.entity.Tag;

import java.io.IOException;

public class UtilityJason {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T getObjectFromText(String value, Class<T> cl) throws IOException {
        return mapper.readValue(value, cl);
    }

    public static <T> String getTextFromObject(T obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

}
