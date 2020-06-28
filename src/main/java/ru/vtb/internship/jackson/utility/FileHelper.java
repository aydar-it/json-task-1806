package ru.vtb.internship.jackson.utility;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHelper {

    public static String getFileContent(String path) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            StringBuilder tmp = new StringBuilder();
            while (scanner.hasNextLine()) {
                tmp.append(scanner.nextLine()).append('\n');
            }
            return tmp.toString();
        }
    }

    public static void writeNewFile(String name, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {
            bw.write(content);
        }
    }
}
