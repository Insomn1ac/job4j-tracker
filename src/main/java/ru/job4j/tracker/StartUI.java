package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.println("Print item's ID: ");
                int userId = Integer.parseInt(scanner.nextLine());
                System.out.println("Print item's name: ");
                String userName = scanner.nextLine();
                Item editItem = new Item();
                editItem.setName(userName);
                tracker.replace(userId, editItem);
                if (tracker.replace(userId, editItem)) {
                    System.out.println("Item: " + userId + " was successfully changed to "
                            + editItem.getName());
                } else {
                    System.out.println("Item wasn't changed");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.println("Print item's ID: ");
                int userId = Integer.parseInt(scanner.nextLine());
                tracker.delete(userId);
                boolean rsl = tracker.delete(userId);
                if (!rsl) {
                    System.out.println("Item: " + userId + " was successfully deleted");
                } else {
                    System.out.println("Item wasn't deleted");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ====");
                System.out.println("Print item's ID: ");
                int userId = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(userId);
                if (item == null) {
                    System.out.println("Cannot find item with ID " + userId);
                } else {
                    System.out.println(tracker.findById(userId) + " was found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.println("Print items name: ");
                String userName = scanner.nextLine();
                Item[] item = tracker.findByName(userName);
                if (item.length < 1) {
                    System.out.println("Cannot find items with name " + userName);
                }
                for (Item value : item) {
                    System.out.println("Item {id: " + value.getId() + "; name: "
                                + value.getName() + "} was found");
                    }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
