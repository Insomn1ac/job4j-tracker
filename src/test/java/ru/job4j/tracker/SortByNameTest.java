package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class SortByNameTest {
    @Test
    public void whenFirstMoreThanSecond() {
        Item first = new Item();
        Item second = new Item();
        first.setName("ABCD");
        second.setName("AGHI");
        Comparator<Item> comparator = new SortByName();
        List<Item> list = Arrays.asList(second, first);
        List<Item> expected = Arrays.asList(first, second);
        list.sort(comparator);
        assertThat(list, is(expected));
    }

    @Test
    public void whenSecondMoreThanFirst() {
        Item first = new Item();
        Item second = new Item();
        first.setName("ABCD");
        second.setName("AGHI");
        Comparator<Item> comparator = new SortByNameReverse();
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
        first.setName("ABCD");
        second.setName("AGHI");
        third.setName("ABCD");
        Comparator<Item> comparator = new SortByName();
        List<Item> list = Arrays.asList(first, second, third);
        List<Item> expected = Arrays.asList(first, third, second);
        list.sort(comparator);
        assertThat(list, is(expected));
    }

}