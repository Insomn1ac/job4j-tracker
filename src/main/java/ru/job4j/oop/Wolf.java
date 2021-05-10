package ru.job4j.oop;

public class Wolf {
    public void tryEat(Ball ball) {
        System.out.println("Повстречал наш колобок волка. Попробовал волк колобка съесть.");
        ball.tryEat(this);
    }
}
