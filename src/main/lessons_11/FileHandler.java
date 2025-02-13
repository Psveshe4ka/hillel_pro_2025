package main.lessons_11;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    public String createFile(String path) {
        Path newFile = Path.of(path); // Создание объекта Path
        try {
            Files.createFile(newFile); // Использование Path для создания файла
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
        return "Created " + newFile;
    }

    public String writeToFile(String path, String content) {
        try {
            Files.writeString(Path.of(path), content); // Использование Path для записи в файл
        } catch (IOException e) {
            return "Write error: " + e.getMessage();
        }
        return "Recorded in " + path;
    }

    public String readFromFile(String path) {
        try {
            return Files.readString(Path.of(path)); // Использование Path для чтения из файла
        } catch (IOException e) {
            return "Read error: " + e.getMessage();
        }
    }
}





