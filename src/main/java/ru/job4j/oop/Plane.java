package ru.job4j.oop;

public class Plane implements Vehicle {
    private String name;
    private int passengers;

    public Plane() {

    }

    public Plane(String name, int passengers) {
        this.name = name;
        this.passengers = passengers;
    }

    public String getName() {
        return name;
    }

    public int getPassengers() {
        return passengers;
    }

    @Override
    public void move() {
        System.out.println("Летает по воздуху");
    }

    @Override
    public void capacity() {
        System.out.println("Вместимость - " + getPassengers() + " пассажиров");
    }
}
