package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestClassTest {

    @Test
    public void twoPlusTwoEqualsFour() {
        TestClass tc = new TestClass();
        assertEquals(4, tc.sum(2,2));
    }

    @Test
    public void isEvenTest() {
        TestClass tc = new TestClass();
        assertTrue(tc.isEven(2));
    }

    @Test
    public void notEvenTest() {
        TestClass tc = new TestClass();
        assertFalse(tc.isEven(3));
    }

    @Test
    public void resultTest() {
        TestClass tc = new TestClass();
        int result = tc.sum(2,3);
        assertTrue(result == tc.sum(2,3));
    }

    @Test
    public void arrayListTest() {
        TestClass tc = new TestClass();
        List<String>fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        assertEquals(3, fruits.size());
        assertTrue(fruits.contains("Apple"));
        assertFalse(fruits.contains("anotherFruit"));
    }
}