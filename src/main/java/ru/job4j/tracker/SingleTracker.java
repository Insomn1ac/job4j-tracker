package ru.job4j.tracker;

public final class SingleTracker {
    private static SingleTracker single;
    private Tracker tracker = new Tracker();

    private SingleTracker() {

    }

    public static SingleTracker getSingle() {
        if (single == null) {
            single = new SingleTracker();
        }
        return single;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }
}
