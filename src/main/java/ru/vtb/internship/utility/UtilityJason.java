package ru.vtb.internship.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.vtb.internship.exceptions.ConverterIOException;
import ru.vtb.internship.exceptions.ConverterJsonProcessingException;

import java.io.IOException;

public class UtilityJason {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public <T> T getObjectFromJson(String value, Class<T> cl) throws ConverterIOException {
        try {
            return mapper.readValue(value, cl);
        } catch (IOException e) {
            throw new ConverterIOException(e.getMessage());
        }
    }

    public <T> String getJsonFromObject(T obj) throws ConverterJsonProcessingException {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConverterJsonProcessingException(e.getMessage());
        }
    }

}
