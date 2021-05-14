package ru.job4j.inheritance;

public class Builder extends Engineer {

    public Builder(String name, String surname, String education, String birthday, House house) {
        super(name, surname, education, birthday, house);
    }

    public double build(House house) {
        return house.getVolume();
    }
}
