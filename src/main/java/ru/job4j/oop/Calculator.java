package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperations(int y) {
        return sum(y) + minus(y) + divide(y) + multiply(y);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Addition: " + sum(10));
        System.out.println("Subtraction: " + minus(10));
        System.out.println("Division: " + calc.divide(10));
        System.out.println("Multiplication: " + calc.multiply(10));
        System.out.println("Sum of all operations: " + calc.sumAllOperations(10));
    }
}
