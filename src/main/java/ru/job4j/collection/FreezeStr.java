package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        String[] strL = left.split("");
        String[] strR = right.split("");
        Map<String, Integer> mapL = new HashMap<>();
        Map<String, Integer> mapR = new HashMap<>();
        for (String l : strL) {
            if (!mapL.containsKey(l)) {
                mapL.put(l, 1);
            } else {
                mapL.put(l, mapL.get(l + 1));
            }
        }
        for (String r : strR) {
            if (!mapR.containsKey(r)) {
                mapR.put(r, 1);
            } else {
                mapR.put(r, mapR.get(r + 1));
            }
        }
        return mapL.equals(mapR);
    }
}
