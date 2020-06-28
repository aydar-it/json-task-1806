package ru.vtb.internship.exceptions;

import java.io.FileNotFoundException;

public class ConverterFileNotFoundException extends ConverterException {
    public ConverterFileNotFoundException() {
    }

    public ConverterFileNotFoundException(String message) {
        super(message);
    }
}
