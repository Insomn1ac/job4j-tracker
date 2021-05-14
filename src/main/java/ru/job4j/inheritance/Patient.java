package ru.job4j.inheritance;

public class Patient {
    private int teeth;
    private Diagnosis diagnosis;

    public Patient(int teeth, Diagnosis diagnosis) {
        this.teeth = teeth;
        this.diagnosis = diagnosis;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
}
