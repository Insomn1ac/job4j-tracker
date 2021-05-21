package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int userId = input.askInt("Enter ID: ");
        if (tracker.delete(userId)) {
            System.out.println("Item " + userId + " was successfully deleted");
        } else {
            System.out.println("Cannot delete item with ID: " + userId
                    + ". Item doesn't exist in Tracker");
        }
        return true;
    }
}
