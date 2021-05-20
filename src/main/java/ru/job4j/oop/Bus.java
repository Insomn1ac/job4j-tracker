package ru.job4j.oop;

public class Bus implements Vehicle {
    private String name;
    private int passengers;

    public Bus() {

    }

    public Bus(String name, int passengers) {
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
        System.out.println("Двигается по скоростным трассам");
    }

    @Override
    public void capacity() {
        System.out.println("Вместимость - " + getPassengers() + " пассажиров");
    }
}
