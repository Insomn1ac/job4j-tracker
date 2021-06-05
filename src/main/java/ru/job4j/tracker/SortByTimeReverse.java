package ru.job4j.tracker;

import java.util.Comparator;

public class SortByTimeReverse implements Comparator<Item> {
    @Override
    public int compare(Item firstTime, Item secondTime) {
        return secondTime.getCreated().compareTo(firstTime.getCreated());
    }
}
