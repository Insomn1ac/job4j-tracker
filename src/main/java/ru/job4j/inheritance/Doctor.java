package ru.job4j.inheritance;

public class Doctor extends Profession {
    private Patient patient;

    public Doctor(String name, String surname, String education, String birthday, Patient patient) {
        super(name, surname, education, birthday);
        this.patient = patient;
    }

    public Diagnosis heal(Patient patient) {
        return patient.getDiagnosis();
    }
}
