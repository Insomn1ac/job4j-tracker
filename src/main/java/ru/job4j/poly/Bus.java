package ru.job4j.poly;

public class Bus implements Transport {
    private boolean drive;
    private int numberOfPassengers;

    @Override
    public void drive() {
        this.drive = true;
    }

    @Override
    public void passengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public double refuel(double amountOfFuel) {
        return amountOfFuel * 45.2;
    }
}
