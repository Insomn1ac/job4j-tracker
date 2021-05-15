package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setFio("Elon Musk");
        student1.setGroup("CS-113");
        student1.setAdmission(new Date());

        System.out.println("Student " + student1.getFio()
                + " learning computer science in group: " + student1.getGroup()
                + ". His date of admission is: " + student1.getAdmission() + ".");
    }
}
