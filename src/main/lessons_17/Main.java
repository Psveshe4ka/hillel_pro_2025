package main.lessons_17;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("iPhone10", "Phone", 2000.0),
                new Product("Mug", "For Home", 15.0),
                new Product("Dumplings", "Food", 15.0)
        );

        Map<String, Double> avgPrices = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
        Optional<Map.Entry<String, Double>> maxEntry = avgPrices.entrySet().stream()
                .max(Map.Entry.comparingByValue());



        System.out.println(avgPrices);
        System.out.println(maxEntry);
    }
}
