package ru.job4j.oop;

public class Hare {
    public void tryEat(Ball ball) {
        System.out.println("Повстречал колобок зайца. Попытался тот нашего колобка съесть.");
        ball.tryEat(this);
    }
}
