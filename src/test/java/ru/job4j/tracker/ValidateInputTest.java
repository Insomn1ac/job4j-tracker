package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenRightInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-2"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-2));
    }

    @Test
    public void whenMultipleRightInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "2", "4", "5"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int[] selected = new int[4];
        selected[0] = input.askInt("Enter menu:");
        selected[1] = input.askInt("Enter menu:");
        selected[2] = input.askInt("Enter menu:");
        selected[3] = input.askInt("Enter menu:");
        assertThat(selected, is(new int[] {0, 2, 4, 5}));
    }
}