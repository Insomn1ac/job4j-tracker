package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "\"раз\"",
                "\"двойка\"",
                "\"троечка\"",
                "\"четвёрка\"",
                "\"пять\"",
                "\"шесть\""
        ));
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("Сравним " + left + " c " + right);
            return left.compareTo(right);
        };
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("Сравним " + right.length() + " с " + left.length());
            return Integer.compare(right.length(), left.length());
        };
        list.sort(cmpText);
        System.out.println(list);
        list.sort(cmpDescSize);
        System.out.println(list);
    }
}
