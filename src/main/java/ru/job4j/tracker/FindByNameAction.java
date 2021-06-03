package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        String userName = input.askStr("Enter name: ");
        List<Item> item = tracker.findByName(userName);
        if (item.size() > 0) {
            for (Item names : item) {
                out.println(names);
            }
        } else {
            out.println("Cannot find item by name: " + userName);
        }
        return true;
    }
}
