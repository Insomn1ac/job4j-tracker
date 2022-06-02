package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void whenSuccessfullyFindItemByName() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "item", LocalDateTime.now());
        tracker.add(item);
        FindByNameAction findByName = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        findByName.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "=== Find items by name ===" + ln
                + tracker.findAll().get(0).toString() + ln);
    }

    @Test
    public void whenItemCannotExist() {
        Output out = new StubOutput();
        Item item = new Item(1, "item", LocalDateTime.now());
        MemTracker tracker = new MemTracker();
        FindByNameAction findByName = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        findByName.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "=== Find items by name ===" + ln
                + "Cannot find item by name: " + item.getName() + ln);
        assertEquals(tracker.findAll(), Collections.emptyList());
    }
}