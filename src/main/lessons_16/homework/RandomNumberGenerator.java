package main.lessons_16.homework;

public class RandomNumberGenerator {
    static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
