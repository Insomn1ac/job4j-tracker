package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException("User is not found!");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid!");
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true),
                    new User("Alexander Druz'", false),
                    new User("Al", true)
            };
            User user = findUser(users, "Al");
                if (validate(user)) {
                    System.out.println("User have an access");
                }
        } catch (UserInvalidException ui) {
            System.out.println(ui.getMessage());
            ui.printStackTrace();
        } catch (UserNotFoundException un) {
            System.out.println(un.getMessage());
            un.printStackTrace();
        }
    }
}
