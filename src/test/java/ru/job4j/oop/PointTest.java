package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenA01B02Then1() {
        Point a = new Point(0, 1);
        Point b = new Point(0, 2);
        double expected = 1;
        double result = a.distance(b);
        Assert.assertEquals(expected, result, 0.0001);
    }

    @Test
    public void whenA00B03Then3() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        double expected = 3;
        double result = a.distance(b);
        Assert.assertEquals(expected, result, 0.0001);
    }

    @Test
    public void whenA00B00Then0() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        double expected = 0;
        double result = a.distance(b);
        Assert.assertEquals(expected, result, 0.0001);
    }
}