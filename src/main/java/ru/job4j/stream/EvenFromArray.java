package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenFromArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-234, 653, -9, -43, 32, 916, -22, -78, 61);
        List<Integer> evenList = list.stream()
                .filter(i -> i > 0)
                .sorted()
                .collect(Collectors.toList());
        evenList.forEach(System.out::println);
    }
}
