package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1234567@mail.ru", "Stepan Vasiliev");
        map.put("qwerty@gmail.com", "Ivan Ivanov");
        map.put("asdfg@outlook.com", "Vasily Petrov");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getValue() + " : " + entry.getKey());
        }
    }
}
