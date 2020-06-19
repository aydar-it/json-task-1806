package ru.vtb.internship.jackson.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UtilityJason {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T getObjectFromJson(String value, Class<T> cl) throws IOException {
        return mapper.readValue(value, cl);
    }

    public static <T> String getJsonFromObject(T obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

}
