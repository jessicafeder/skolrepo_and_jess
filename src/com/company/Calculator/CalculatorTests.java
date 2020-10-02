package com.company.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    private final Calculator calculator = new Calculator();

    @Test
    void addition() {
        assertEquals(3, calculator.add(1, 2));
    }
}