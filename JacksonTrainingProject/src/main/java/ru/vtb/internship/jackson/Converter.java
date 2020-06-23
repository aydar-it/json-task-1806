package ru.vtb.internship.jackson;

public interface Converter {
    <T> void convert(String fileName, Class<T> cl);
}
