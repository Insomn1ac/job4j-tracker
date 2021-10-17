package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static SingleTracker single;
    private MemTracker memTracker = new MemTracker();

    private SingleTracker() {

    }

    public static SingleTracker getSingle() {
        if (single == null) {
            single = new SingleTracker();
        }
        return single;
    }

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public boolean delete(int id) {
        return memTracker.delete(id);
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }
}
