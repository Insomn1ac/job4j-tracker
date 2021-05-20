package ru.job4j.oop;

public class Train implements Vehicle {
    private String name;
    private int passengers;

    public Train() {

    }

    public Train(String name, int passengers) {
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
        System.out.println("Едет по рельсам");
    }

    @Override
    public void capacity() {
        System.out.println("Вместимость - " + getPassengers() + " пассажиров");
    }
}
