package ru.vtb.internship;

public interface Converter {
    <T> void convert(String fileName, Class<T> cl);
}
