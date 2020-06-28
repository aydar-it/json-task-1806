package ru.vtb.internship.exceptions;

import java.io.IOException;

public class ConverterIOException extends ConverterException {
    public ConverterIOException() {
    }

    public ConverterIOException(String message) {
        super(message);
    }
}
