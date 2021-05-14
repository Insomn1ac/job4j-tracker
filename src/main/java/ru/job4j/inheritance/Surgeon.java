package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private boolean haveQualification;

    public Surgeon(String name, String surname, String education, String birthday,
                   Patient patient, boolean haveQualification) {
        super(name, surname, education, birthday, patient);
        this.haveQualification = haveQualification;
    }

    public void surge(Patient patient) {

    }
}
