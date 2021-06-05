package ru.job4j.tracker;

import java.util.Comparator;

public class SortByTime implements Comparator<Item> {
    @Override
    public int compare(Item firstTime, Item secondTime) {
        return firstTime.getCreated().compareTo(secondTime.getCreated());
    }
}
