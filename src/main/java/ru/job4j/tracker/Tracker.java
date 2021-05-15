package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll(Item[] items, int size) {
        Item[] itemsWithoutNull = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            Item name = items[i];
            if (name != null) {
                itemsWithoutNull[size] = name;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] findName = new Item[size];
        int rsl = 0;
        for (int i = 0; i < items.length; i++) {
            if (key.equals(items[i].getName())) {
                findName[rsl] = items[i];
                rsl++;
            }
        }
        findName = Arrays.copyOf(findName, rsl);
        return findName;
    }
}