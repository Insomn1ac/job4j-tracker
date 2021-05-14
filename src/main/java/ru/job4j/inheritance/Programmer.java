package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String calculate;

    public Programmer(String name, String surname, String education, String birthday, House house,
                      String calculate) {
        super(name, surname, education, birthday, house);
        this.calculate = calculate;
    }

    public void calcStrength(House house) {

    }
}
