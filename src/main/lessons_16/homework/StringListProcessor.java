package main.lessons_16.homework;

public class StringListProcessor {
    static int countUppercase(String s) {
        return (int) s.chars().filter(Character::isUpperCase).count();
    }
}
