package main.lessons_10;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
    private final static String BASE_PATH = "files/";

    public String writeFile(String fileName, String fileContent) {
        try (FileWriter fw = new FileWriter(BASE_PATH + fileName + ".txt")) {
            fw.write(fileContent);
            return "Success.";
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    public String readFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            int sym;
            while ((sym = reader.read()) != -1) {
                stringBuilder.append((char) sym);
            }
            return stringBuilder.toString();
        } catch (IOException ex) {
            return "Error: " + ex.getMessage();
        }
    }
}

