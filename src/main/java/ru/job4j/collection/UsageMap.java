package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1234567@mail.ru", "Stepan Vasiliev");
        map.put("qwerty@gmail.com", "Ivan Ivanov");
        map.put("asdfg@outlook.com", "Vasily Petrov");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value + " : " + key);
        }
    }
}
