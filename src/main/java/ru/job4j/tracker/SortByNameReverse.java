package ru.job4j.tracker;

import java.util.Comparator;

public class SortByNameReverse implements Comparator<Item> {
    @Override
    public int compare(Item firstName, Item secondName) {
        return secondName.getName().compareTo(firstName.getName());
    }
}
