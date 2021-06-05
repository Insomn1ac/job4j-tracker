package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class SortByIdTest {
    @Test
    public void whenFirstMoreThenSecond() {
        Item first = new Item();
        Item second = new Item();
        first.setId(1);
        second.setId(2);
        Comparator<Item> comparator = new SortById();
        List<Item> list = Arrays.asList(second, first);
        List<Item> expected = Arrays.asList(first, second);
        list.sort(comparator);
        assertThat(list, is(expected));
    }

    @Test
    public void whenSecondMoreThanFirst() {
        Item first = new Item();
        Item second = new Item();
        first.setId(1);
        second.setId(2);
        Comparator<Item> comparator = new SortByIdReverse();
        List<Item> list = Arrays.asList(first, second);
        List<Item> expected = Arrays.asList(second, first);
        list.sort(comparator);
        assertThat(list, is(expected));
    }

    @Test
    public void whenEquals() {
        Item first = new Item();
        Item second = new Item();
        Item third = new Item();
        first.setId(1);
        second.setId(2);
        third.setId(1);
        Comparator<Item> comparator = new SortById();
        List<Item> list = Arrays.asList(first, second, third);
        List<Item> expected = Arrays.asList(first, third, second);
        list.sort(comparator);
        assertThat(list, is(expected));
    }
}