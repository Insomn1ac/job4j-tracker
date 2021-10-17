package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit item ===");
        int userId = input.askInt("Enter ID: ");
        String userName = input.askStr("Enter name: ");
        Item item = new Item(userName);
        if (tracker.replace(userId, item)) {
            out.println("Item successfully replaced");
        } else {
            out.println("Cannot replace item with ID: " + userId
                    + ". There is no such item in Tracker");
        }
        return true;
    }
}
