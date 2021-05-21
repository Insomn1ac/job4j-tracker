package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int userId = input.askInt("Enter ID: ");
        String userName = input.askStr("Enter name: ");
        Item item = new Item(userName);
        if (tracker.replace(userId, item)) {
            System.out.println("Item successfully replaced");
        } else {
            System.out.println("Cannot replace item with ID: " + userId
                    + ". There is no such item in Tracker");
        }
        return true;
    }
}
