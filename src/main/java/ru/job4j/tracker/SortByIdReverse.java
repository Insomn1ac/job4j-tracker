package ru.job4j.tracker;

import java.util.Comparator;

public class SortByIdReverse implements Comparator<Item> {
    @Override
    public int compare(Item firstId, Item secondId) {
        return Integer.compare(secondId.getId(), firstId.getId());
    }
}
