package ru.job4j.tracker;

import java.util.Comparator;

public class SortById implements Comparator<Item> {
    @Override
    public int compare(Item firstId, Item secondId) {
        return Integer.compare(firstId.getId(), secondId.getId());
    }
}
