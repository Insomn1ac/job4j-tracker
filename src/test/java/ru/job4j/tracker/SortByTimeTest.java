package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortByTimeTest {
    @Test
    public void whenFirstMoreThanSecond() {
        Item first = new Item();
        Item second = new Item();
        first.setCreated(LocalDateTime.now());
        second.setCreated(LocalDateTime.of(2030, 6, 5, 17, 15));
        Comparator<Item> comparator = new SortByTime();
        List<Item> list = Arrays.asList(second, first);
        List<Item> expected = Arrays.asList(first, second);
        list.sort(comparator);
        assertThat(list, is(expected));
    }

    @Test
    public void whenSecondMoreThanFirst() {
        Item first = new Item();
        Item second = new Item();
        first.setCreated(LocalDateTime.now());
        second.setCreated(LocalDateTime.of(2030, 6, 5, 17, 15));
        Comparator<Item> comparator = new SortByTimeReverse();
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
        first.setCreated(LocalDateTime.now());
        second.setCreated(LocalDateTime.of(2030, 6, 5, 17, 15));
        third.setCreated(LocalDateTime.now());
        Comparator<Item> comparator = new SortByTime();
        List<Item> list = Arrays.asList(first, second, third);
        List<Item> expected = Arrays.asList(first, third, second);
        list.sort(comparator);
        assertThat(list, is(expected));
    }
}