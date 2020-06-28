package ru.vtb.internship.utility;

import ru.vtb.internship.exceptions.ConverterFileNotFoundException;
import ru.vtb.internship.exceptions.ConverterIOException;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHelper {

    public String getFileContent(String path) throws ConverterFileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            StringBuilder tmp = new StringBuilder();
            while (scanner.hasNextLine()) {
                tmp.append(scanner.nextLine()).append('\n');
            }
            return tmp.toString();
        } catch (FileNotFoundException e) {
            throw new ConverterFileNotFoundException(e.getMessage());
        }
    }

    public void writeNewFile(String name, String content) throws ConverterIOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {
            bw.write(content);
        } catch (IOException e) {
            throw new ConverterIOException(e.getMessage());
        }
    }
}
