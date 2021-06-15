package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        String[] strL = left.split("");
        String[] strR = right.split("");
        Map<String, Integer> mapL = new HashMap<>();
        for (String l : strL) {
            int count = mapL.getOrDefault(l, 0);
            mapL.put(l, count + 1);
        }
        for (String r : strR) {
            Integer value = mapL.get(r);
            if (!mapL.containsKey(r)) {
                return false;
            }
            if (mapL.containsKey(r) && value == 1) {
                mapL.remove(r);
            }
            if (mapL.containsKey(r) && value > 1) {
                mapL.put(r, value - 1);
            }
        }
        return mapL.size() == 0;
    }
}
