package ru.job4j.oop;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void when1MaxTo2Then2() {
        int a = 1;
        int b = 2;
        int expected = 2;
        int out = Max.max(a, b);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void when4MaxTo1And2Then4() {
        int a = 4;
        int b = 1;
        int c = 2;
        int expected = 4;
        int out = Max.max(a, b, c);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void when5MaxTo8And4And0Then8() {
        int a = 5;
        int b = 8;
        int c = 4;
        int d = 0;
        int expected = 8;
        int out = Max.max(a, b, c, d);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void when6EqualsTo6And6Then6() {
        int a = 6;
        int b = 6;
        int c = 6;
        int expected = 6;
        int out = Max.max(a, b, c);
        Assert.assertEquals(expected, out);
    }
}