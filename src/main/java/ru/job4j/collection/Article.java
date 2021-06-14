package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        Set<String> orig = new HashSet<>();
        String[] words = origin.replaceAll("[,.;!:]", "").split("\\s+");
        String[] wordsExample = line.split("\\s+");
        Collections.addAll(orig, words);
        for (String s : wordsExample) {
            if (!orig.contains(s)) {
                rsl = false;
            }
        }
        return rsl;
    }
}
