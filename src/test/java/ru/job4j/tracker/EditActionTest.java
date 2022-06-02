package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EditActionTest {

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditAction edit = new EditAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        edit.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "=== Edit item ===" + ln + "Item successfully replaced" + ln);
        assertEquals(tracker.findAll().get(0).getName(), replacedName);
    }

    @Test
    public void whenCannotReplaceItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        EditAction edit = new EditAction(out);
        Input input = mock(Input.class);
        edit.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "=== Edit item ===" + ln + "Cannot replace item with ID: 0"
                + ". There is no such item in Tracker" + ln);
        assertEquals(tracker.findAll().get(0).getName(), "Replaced item");
    }
}