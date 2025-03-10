package main.lessons_16.homework;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        MathOperation addition = new MathOperation() {
            public int operate(int a, int b) {
                return a + b;
            }
        };
        System.out.println(" Добавления " + addition.operate(10, 5));
        StringManipulator upperCaseConverter = s -> s.toUpperCase();
        System.out.println("Верхний Регистр " + upperCaseConverter.manipulate("Hello, World!"));
        Function<String, Integer> countUpperCaseFunction = StringListProcessor::countUppercase;
        String testString = "Тут 5 Символов В Верхнем Регистре";
        System.out.println(" Количество Верхний регистр  " + countUpperCaseFunction.apply(testString));

        Supplier<Integer> randomSupplier = () -> RandomNumberGenerator.generateRandomNumber(1, 100);
        System.out.println("Случайное число " + randomSupplier.get());
    }
}


