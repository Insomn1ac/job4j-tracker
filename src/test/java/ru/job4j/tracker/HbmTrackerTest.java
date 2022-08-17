package ru.job4j.tracker;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class HbmTrackerTest {

    @Test
    public void whenAddItemThenFindItById() {
        HbmTracker tracker = new HbmTracker();
        Item itm = new Item(1, "item1", "desc1", LocalDateTime.now());
        tracker.add(itm);
        Item rsl = tracker.findById(1);
        assertThat(rsl.getDescription()).isEqualTo(itm.getDescription());
    }

    @Test
    public void whenAddItemsListThenFindItemByName() {
        HbmTracker tracker = new HbmTracker();
        List<Item> items = List.of(
                new Item(1, "item1", "desc1", LocalDateTime.now().withNano(0)),
                new Item(2, "item2", "desc2", LocalDateTime.now().withNano(0)),
                new Item(3, "item1", "desc3", LocalDateTime.now().withNano(0))
        );
        items.forEach(tracker::add);
        List<Item> rsl = tracker.findByName("item1");
        assertThat(rsl.get(0).getCreated()).isEqualTo(items.get(0).getCreated());
        assertThat(rsl.size()).isEqualTo(2);
    }

    @Test
    public void whenAddItemsListThenFindAllItems() {
        HbmTracker tracker = new HbmTracker();
        List<Item> items = List.of(
                new Item(1, "item1", "desc1", LocalDateTime.now().withNano(0)),
                new Item(2, "item2", "desc2", LocalDateTime.now().withNano(0)),
                new Item(3, "item3", "desc3", LocalDateTime.now().withNano(0))
        );
        items.forEach(tracker::add);
        List<Item> rsl = tracker.findAll();
        assertThat(rsl.size()).isEqualTo(3);
    }

    @Test
    public void whenDeleteItem() {
        HbmTracker tracker = new HbmTracker();
        List<Item> items = List.of(
                new Item(1, "item1", "desc1", LocalDateTime.now().withNano(0)),
                new Item(2, "item2", "desc2", LocalDateTime.now().withNano(0)),
                new Item(3, "item3", "desc3", LocalDateTime.now().withNano(0))
        );
        items.forEach(tracker::add);
        boolean isDeleted = tracker.delete(1);
        List<Item> rsl = tracker.findAll();
        assertThat(isDeleted).isTrue();
        assertThat(rsl.size()).isEqualTo(2);
        assertThat(rsl.get(1).getName()).isEqualTo("item3");
    }

    @Test
    public void whenReplaceItem() {
        HbmTracker tracker = new HbmTracker();
        List<Item> items = List.of(
                new Item(1, "item1", "desc1", LocalDateTime.now().withNano(0)),
                new Item(2, "item2", "desc2", LocalDateTime.now().withNano(0)),
                new Item(3, "item3", "desc3", LocalDateTime.now().withNano(0))
        );
        items.forEach(tracker::add);
        boolean isReplaced = tracker.replace(1, new Item(
                1, "new item1", "new desc1", LocalDateTime.now())
        );
        List<Item> rsl = tracker.findAll();
        assertThat(isReplaced).isTrue();
        assertThat(rsl.size()).isEqualTo(items.size());
        assertThat(rsl.get(0).getName()).isEqualTo("new item1");
        assertThat(rsl.get(0).getCreated()).isAfter(rsl.get(2).getCreated());
    }
}