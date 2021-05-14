package ru.job4j.inheritance;

public class Diagnosis {
    private String name;
    private int teeth;

    public Diagnosis(String name) {
        this.name = name;
    }

    public Diagnosis(int teeth) {
        this.teeth = teeth;
    }

    public String getName() {
        return name;
    }

    public int getTeeth() {
        return teeth;
    }
}
