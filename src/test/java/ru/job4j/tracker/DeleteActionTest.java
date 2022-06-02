package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void whenSuccessfullyDeleteItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item"));
        Item rsl = tracker.findAll().get(0);
        DeleteAction delete = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        delete.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "=== Delete item ===" + ln
                + "Item " + rsl.getId() + " was successfully deleted" + ln);
        assertEquals(tracker.findAll(), Collections.emptyList());
    }

    @Test
    public void whenItemCannotExist() {
        Output out = new StubOutput();
        Item item = new Item(1, "item", LocalDateTime.now());
        MemTracker tracker = new MemTracker();
        DeleteAction delete = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        delete.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "=== Delete item ===" + ln
                + "Cannot delete item with ID: " + item.getId()
                + ". Item doesn't exist in Tracker" + ln);
        assertEquals(tracker.findAll(), Collections.emptyList());
    }
}