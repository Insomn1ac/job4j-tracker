package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println(item + " was created");
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Tracker doesn't contain any items yet");
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                int userId = Integer.parseInt(input.askStr("Enter ID: "));
                String userName = input.askStr("Enter name: ");
                Item item = new Item(userName);
                if (tracker.replace(userId, item)) {
                    System.out.println("Item successfully replaced");
                } else {
                    System.out.println("Cannot replace item with ID: " + userId
                            + ". There is no such item in Tracker");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                int userId = Integer.parseInt(input.askStr("Enter ID: "));
                if (tracker.delete(userId)) {
                    System.out.println("Item successfully deleted");
                } else {
                    System.out.println("Cannot delete item with ID: " + userId
                            + ". Item doesn't exist in Tracker");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                int userId = Integer.parseInt(input.askStr("Enter ID: "));
                Item item = tracker.findById(userId);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Cannot find item by ID: " + userId);
                }
            } else if (select == 5) {
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
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
