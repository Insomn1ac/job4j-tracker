package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active?: " + this.active);
        System.out.println("Status: " + this.status);
        System.out.println("Message: " + this.message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        System.out.println();
        Error err = new Error(true, 3, "Goodbye!");
        err.printInfo();
        System.out.println();
        Error error1 = new Error(true, 1, "Stop!");
        error1.printInfo();
    }
}
