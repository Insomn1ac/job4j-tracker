package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenCollect() {
        List<Profile> profileList = List.of(
                new Profile(new Address("Moscow", "Lubyanka", 7, 32)),
                new Profile(new Address("Saint-Petersburg", "Nevskiy", 39, 2)),
                new Profile(new Address("Tula", "Lenina", 3, 5))
        );
        Profiles prof = new Profiles();
        List<Address> rsl = prof.collect(profileList);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lubyanka", 7, 32));
        expected.add(new Address("Saint-Petersburg", "Nevskiy", 39, 2));
        expected.add(new Address("Tula", "Lenina", 3, 5));
        assertEquals(rsl, expected);
    }
}