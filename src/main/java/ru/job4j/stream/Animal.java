package ru.job4j.stream;

public class Animal {
    private String species;
    private int age;
    private String feeding;
    private int maxSpeed;
    private boolean mammal;
    private String gender;

    static class Builder {
        private String species;
        private int age;
        private String feeding;
        private int maxSpeed;
        private boolean mammal;
        private String gender;

        Builder buildSpecies(String species) {
            this.species = species;
            return this;
        }

        Builder buildAge(int age) {
            this.age = age;
            return this;
        }

        Builder buildFeeding(String feeding) {
            this.feeding = feeding;
            return this;
        }

        Builder buildMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder buildMammal(boolean mammal) {
            this.mammal = mammal;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Animal build() {
            Animal animal = new Animal();
            animal.species = species;
            animal.age = age;
            animal.feeding = feeding;
            animal.maxSpeed = maxSpeed;
            animal.mammal = mammal;
            animal.gender = gender;
            return animal;
        }
    }

    @Override
    public String toString() {
        return "Animal{"
                + "species='" + species + '\''
                + ", age=" + age
                + ", feeding='" + feeding + '\''
                + ", maxSpeed=" + maxSpeed
                + ", mammal=" + mammal
                + ", gender='" + gender + '\''
                + '}';
    }

    public static void main(String[] args) {
        Animal animal = new Builder().buildSpecies("giraffe")
                .buildAge(23)
                .buildFeeding("herbivore")
                .buildMaxSpeed(50)
                .buildMammal(true)
                .buildGender("female")
                .build();
        System.out.println(animal);
    }
}
