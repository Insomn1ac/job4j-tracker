package ru.job4j.tracker;

import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in =
                     SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertEquals(tracker.findById(item.getId()), item);
    }

    @Test
    public void whenReplaceItemAndFindByIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item");
        Item item2 = new Item("new item");
        tracker.add(item1);
        assertTrue(tracker.replace(item1.getId(), item2));
    }

    @Test
    public void whenFindAllThenMustBeTheSameWithList() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> list = new ArrayList<>();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        list.add(item1);
        list.add(item2);
        tracker.add(item1);
        tracker.add(item2);
        assertEquals(tracker.findAll(), list);
    }

    @Test
    public void whenDeleteItemAndCompareWithListThenMustBeDeleted() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> list = new ArrayList<>();
        Item item = new Item("item");
        list.add(item);
        tracker.add(item);
        assertEquals(tracker.findAll(), list);
        assertTrue(tracker.delete(item.getId()));
        assertEquals(tracker.findAll(), List.of());
    }

    @Test
    public void whenFindByIDThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertEquals(tracker.findById(item.getId()), item);
    }

    @Test
    public void whenFindByNameThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        List<Item> list = new ArrayList<>();
        list.add(item);
        tracker.add(item);
        assertEquals(list, tracker.findByName(item.getName()));
    }
}