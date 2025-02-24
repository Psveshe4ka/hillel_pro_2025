package main.lessons_15.homework;

import java.util.HashMap;
import java.util.Map;

public class DataRepository {

    public Map<Integer, String> getData() {
        Map<Integer, String > map = new HashMap<>();
        map.put(Integer.valueOf("387"),"Lucy");
        map.put(Integer.valueOf("231"),"Alice");
        map.put(Integer.valueOf("394"), "Bob");
        map.put(Integer.valueOf("174"), "Tom");

        return map;
    }
}

