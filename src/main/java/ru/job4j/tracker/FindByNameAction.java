package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String userName = input.askStr("Enter name: ");
        Item[] item = tracker.findByName(userName);
        if (item.length > 0) {
            for (Item names : item) {
                System.out.println(names);
            }
        } else {
            System.out.println("Cannot find item by name: " + userName);
        }
        return true;
    }
}
