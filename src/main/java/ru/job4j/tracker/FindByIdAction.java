package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find item by id ===");
        int userId = input.askInt("Enter ID: ");
        Item item = tracker.findById(userId);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Cannot find item by ID: " + userId);
        }
        return true;
    }
}
