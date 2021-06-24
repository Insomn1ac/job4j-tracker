package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void whenMatrixConvertedToList() {
        Integer[][] matrix = new Integer[][] {{1, 2}, {3, 4}, {5, 6, 7}};
        MatrixToList mtl = new MatrixToList();
        List<Integer> rsl = mtl.convert(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(rsl, expected);
    }
}