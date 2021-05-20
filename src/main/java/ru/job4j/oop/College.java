package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman vasya = new Freshman();
        Student vasiliy = vasya;
        Object pupil = vasiliy;
    }
}
