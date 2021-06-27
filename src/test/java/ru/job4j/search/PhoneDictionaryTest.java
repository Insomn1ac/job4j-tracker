package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindBySurname() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Arsentev");
        assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Elon", "Musk", "1234567", "San Francisco")
        );
        var persons = phones.find("1234567");
        assertThat(persons.get(0).getAddress(), is("San Francisco"));
    }

    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Elon", "Musk", "1234567", "San Francisco")
        );
        var persons = phones.find("San Francisco");
        assertThat(persons.get(0).getName(), is("Elon"));
    }

    @Test
    public void whenNotFound() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Ivanov", "2345678", "Moscow")
        );
        var persons = phones.find("Kaluga");
        assertTrue(persons.isEmpty());
    }
}