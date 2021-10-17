package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ===");
        int userId = input.askInt("Enter ID: ");
        if (tracker.delete(userId)) {
            out.println("Item " + userId + " was successfully deleted");
        } else {
            out.println("Cannot delete item with ID: " + userId
                    + ". Item doesn't exist in Tracker");
        }
        return true;
    }
}
