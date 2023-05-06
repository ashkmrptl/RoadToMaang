package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();

        System.out.println(map);

        map.computeIfAbsent("abc", s -> Collections.singletonList(getRandomString()));

        System.out.println(map);

        map.computeIfAbsent("xyz", s -> Collections.singletonList(getRandomString()));

        System.out.println(map);
    }

    private static String getRandomString() {
        return String.valueOf(new Random().nextInt());
    }
}
