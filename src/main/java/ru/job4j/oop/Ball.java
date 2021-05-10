package ru.job4j.oop;

public class Ball {
    public void tryEat(Hare hare) {
        System.out.println("Не смог заяц съесть колобка. Ушел тот дальше.");
    }

    public void tryEat(Wolf wolf) {
        System.out.println("Не вышло, и от волка колобок ушел.");
    }

    public void tryEat(Fox fox) {
        System.out.println("А лиса колобка-то и съела.");
    }
}
