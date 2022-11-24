package edu.serjmaks.junit.ex01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExtendedListTest {

    @Test
    void map() {
        ExtendedList<Integer> integers = new ExtendedList<>(2, 3, 4);
        ExtendedList<Integer> expected = new ExtendedList<>(4, 9, 16);
        List<Integer> actual = integers.map(x -> x * x);
        assertEquals(expected, actual);
    }

    @Test
    void map_shouldReturnEmptyList() {
        ExtendedList<Integer> integers = new ExtendedList<>();
        ExtendedList<Integer> expected = new ExtendedList<>();
        List<Integer> actual = integers.map(x -> x * x);
        assertEquals(expected, actual);
    }

    @Test
    void fill() {
        ExtendedList<Integer> integers = new ExtendedList<>();
        ExtendedList<Integer> expected = new ExtendedList<>(1,2,3,4,5);
        Supplier<Integer> supplier = () -> (int) (Math.random() * 100);
        List<Integer> actual = integers.fill(supplier, 5);
        int expectedSize = expected.size();
        int actualSize = actual.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    @DisplayName("should return true, if all elements is even")
    void forAll_shouldReturnTrue() {
        ExtendedList<Integer> integers = new ExtendedList<>(2, 4, 6);
        Predicate<Integer> predicate = x -> x % 2 == 0;
        boolean actual = integers.forAll(predicate);
        assertTrue(actual);
    }

    @Test
    @DisplayName("should return false")
    void forAll_shouldReturnFalse() {
        ExtendedList<Integer> integers = new ExtendedList<>(2, 3, 6);
        Predicate<Integer> predicate = x -> x % 2 == 0;
        boolean actual = integers.forAll(predicate);
        assertFalse(actual);
    }

    @Test
    void partition() {
        Map<Boolean, List<Integer>> map = new HashMap<>();
        ExtendedList<Integer> integers = new ExtendedList<>(2, 4, 6);
        List<Integer> emptyList = new ArrayList<>();
        map.put(true, integers);
        map.put(false, emptyList);
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Map<Boolean, List<Integer>> expected = map;
        Map<Boolean, List<Integer>> actual = integers.partition(predicate);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should separate input list")
    void partition_separateInputList() {
        // 1 - given
        ExtendedList<Integer> integers = new ExtendedList<>(1, 2, 3, 4, 5, 6, 7);
        Map<Boolean, List<Integer>> expected = new HashMap<>();
        expected.put(true, List.of(2, 4, 6));
        expected.put(false, List.of(1, 3, 5, 7));

        // 2 - when
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Map<Boolean, List<Integer>> actual = integers.partition(predicate);

        // 3 - then
        assertEquals(expected, actual);
    }

    @Test
    void reduce_additionOperation() {
        ExtendedList<Integer> integers = new ExtendedList<>(2,2,3);
        Integer expected = 7;
        BinaryOperator<Integer> addition = (a, b) -> a + b;
        Integer actual = integers.reduce(addition, 0);
        assertEquals(expected, actual);
    }

    @Test
    void reduce_multiplyOperation(){
        ExtendedList<Integer> integers = new ExtendedList<>(2,2,3);
        Integer expected = 12;
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        Integer actual = integers.reduce(multiply, 1);
        assertEquals(expected, actual);
    }

    @Test
    void reduce_MultiplyOperationShouldEqualsNull(){
        ExtendedList<Integer> integers = new ExtendedList<>(2,2,3);
        Integer expected = 0;
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        Integer actual = integers.reduce(multiply, 0);
        assertEquals(expected, actual);
    }
}
