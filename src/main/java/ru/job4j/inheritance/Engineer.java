package ru.job4j.inheritance;

public class Engineer extends Profession {
    private House house;

    public Engineer(String name, String surname, String education, String birthday, House house) {
        super(name, surname, education, birthday);
        this.house = house;
    }

    public double project(House house) {
        return house.getArea();
    }
}
