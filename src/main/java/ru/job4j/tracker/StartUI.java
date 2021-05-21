package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {

    }

    public static void showItems(Tracker tracker) {

    }

    public static void editItem(Input input, Tracker tracker) {

    }

    public static void deleteItem(Input input, Tracker tracker) {

    }

    public static void findById(Input input, Tracker tracker) {

    }

    public static void findByName(Input input, Tracker tracker) {

    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAllAction(),
                new EditAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
