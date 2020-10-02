package com.company.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing Calculator")
public class CalculatorTests {
    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Testing that addition works")
    void addition() {
        assertEquals(3, calculator.add(1, 2));
        assertEquals(5, calculator.add(-5, 10));
        assertEquals(1400000, calculator.add(700000, 700000));
    }

    @Test
    @DisplayName("Testing that addition works")
    void subtraction() {
        assertEquals(3, calculator.sub(5, 2));
        assertEquals(5, calculator.sub(10, 5));
        assertEquals(10, calculator.sub(20, 10));
    }

    @Test
    @DisplayName("Testing that addition works")
    void division() {
        assertEquals(2, calculator.div(4, 2));
        assertEquals(2, calculator.div(10, 5));
        assertEquals(2, calculator.div(20, 10));

    }

    @Test
    @DisplayName("Testing that addition works")
    void modulo() {
        assertEquals(1, calculator.mod(5, 2));
        assertEquals(0, calculator.mod(10, 5));
        assertEquals(0, calculator.mod(20, 10));
    }

    @Test
    @DisplayName("Testing Max")
    void max() {
        assertEquals(5, calculator.max(5, 2));
        assertEquals(10, calculator.max(10, 5));
        assertEquals(20, calculator.max(20, 10));
    }



}