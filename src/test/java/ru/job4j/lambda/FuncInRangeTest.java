package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FuncInRangeTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FuncInRange.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = FuncInRange.diapason(2, 5, x -> x * x + 4);
        List<Double> expected = Arrays.asList(8D, 13D, 20D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        List<Double> result = FuncInRange.diapason(2, 5, x -> 2 * Math.pow(x, x));
        List<Double> expected = Arrays.asList(8D, 54D, 512D);
        assertThat(result, is(expected));
    }
}