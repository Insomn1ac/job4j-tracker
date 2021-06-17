package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven");
        BiConsumer<Integer, String> biCon = map::put;
        int n = 1;
        for (String s : strings) {
            biCon.accept(n++, s);
        }

        BiPredicate<Integer, String> biPred = (i, s) -> (i % 2 == 0 && s.length() == 4);
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        Consumer<String> con = System.out::println;
        for (String s : sup.get()) {
            con.accept(s);
        }
        Function<String, String> func = String::toUpperCase;
        for (String s : sup.get()) {
            System.out.println(func.apply(s));
        }
    }
}