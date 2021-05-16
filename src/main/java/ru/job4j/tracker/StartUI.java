package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test"));
        System.out.println(tracker.findById(1));
        Item item = new Item(24, "TEST");
        System.out.println(item);
    }
}
