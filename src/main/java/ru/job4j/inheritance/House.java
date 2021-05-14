package ru.job4j.inheritance;

public class House {
    private double area;
    private double volume;

    public House(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }
}
