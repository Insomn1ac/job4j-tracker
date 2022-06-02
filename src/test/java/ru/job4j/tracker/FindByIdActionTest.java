package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void whenSuccessfullyFindItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item"));
        FindByIdAction find = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "=== Find item by id ===" + ln
                + tracker.findAll().get(0).toString() + ln);
    }

    @Test
    public void whenItemCannotExist() {
        Output out = new StubOutput();
        Item item = new Item(1, "item", LocalDateTime.now());
        MemTracker tracker = new MemTracker();
        FindByIdAction find = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "=== Find item by id ===" + ln
                + "Cannot find item by ID: " + item.getId() + ln);
        assertEquals(tracker.findAll(), Collections.emptyList());
    }
}