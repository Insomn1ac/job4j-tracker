package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int workTime;

    public Dentist(String name, String surname, String education, String birthday,
                   Patient patient, int workTime) {
        super(name, surname, education, birthday, patient);
        this.workTime = workTime;
    }

    public void pullOut(Patient patient) {

    }
}
