package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {

    }

    public int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("Number must be positive or zero");
        }
        for (int i = 1; i <= n; i++) {
            rsl *= i;
        }
        return rsl;
    }
}