package ru.vtb.internship.jackson.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UtilityJason {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T getObjectFromJson(String value, Class<T> cl) throws IOException {
        return mapper.readValue(value, cl);
    }

    public static <T> String getJsonFromObject(T obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

}
