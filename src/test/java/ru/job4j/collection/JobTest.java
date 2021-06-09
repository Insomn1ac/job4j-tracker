package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenDescByName() {
        Comparator<Job> name = new JobDescByName();
        int rsl = name.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescByPriority() {
        Comparator<Job> name = new JobDescByPriority();
        int rsl = name.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAscByName() {
        Comparator<Job> name = new JobAscByName();
        int rsl = name.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenAscByPriority() {
        Comparator<Job> name = new JobAscByPriority();
        int rsl = name.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenDescComparatorByNameAndPriority() {
        Comparator<Job> namePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = namePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenAscComparatorByNameAndPriority() {
        Comparator<Job> namePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = namePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenNameAndPriorityEqual() {
        Comparator<Job> namePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = namePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, equalTo(0));
    }
}