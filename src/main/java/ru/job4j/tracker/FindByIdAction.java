package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ===");
        int userId = input.askInt("Enter ID: ");
        Item item = tracker.findById(userId);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Cannot find item by ID: " + userId);
        }
        return true;
    }
}
