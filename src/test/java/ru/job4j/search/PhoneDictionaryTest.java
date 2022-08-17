package ru.job4j.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindBySurname() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Arsentev");
        assertThat(persons.get(0).getName()).isEqualTo("Petr");
    }

    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Elon", "Musk", "1234567", "San Francisco")
        );
        var persons = phones.find("1234567");
        assertThat(persons.get(0).getAddress()).isEqualTo("San Francisco");
    }

    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Elon", "Musk", "1234567", "San Francisco")
        );
        var persons = phones.find("San Francisco");
        assertThat(persons.get(0).getName()).isEqualTo("Elon");
    }

    @Test
    public void whenNotFound() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Ivanov", "2345678", "Moscow")
        );
        var persons = phones.find("Kaluga");
        assertThat(persons.isEmpty()).isTrue();
    }
}