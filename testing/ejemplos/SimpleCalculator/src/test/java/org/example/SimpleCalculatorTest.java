package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {
    @Test
    public void twoPlusTwoShouldEqualFour() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(4, calculator.add(2,2));
    }

    @Test
    public void threePlusSevenShouldEqualFour() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(10, calculator.add(3,7));
    }
}