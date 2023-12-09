package com.andrei.rest.unit_test;

import com.andrei.rest.services.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void testAddition_ShouldPass_WithValidInput() {
        //GIVEN
        int firstNumber = 3;
        int secondNumber = 15;
        int expectedResult = firstNumber + secondNumber;

        //WHEN
        int result = calculator.add(firstNumber, secondNumber);

        //THEN
        Assertions.assertEquals(expectedResult, result, "The addition result should be equal to the expected result.");
    }

    @Test
    void testAddition_ShouldFail_WhenResultExceedingIntegerMaxValue() {
        //GIVEN
        int firstNumber = Integer.MAX_VALUE;
        int secondNumber = 1;
        long expectedResult = (long) firstNumber + secondNumber;

        //WHEN
        int result = calculator.add(firstNumber, secondNumber);
        System.out.println("Expected result:" + expectedResult);
        System.out.println("Actual result:" + result);

        //WHEN & THEN
        assertNotEquals(expectedResult, result);
    }

    @Test
    void testSubtract_ShouldPass_WithValidInput() {
        //GIVEN
        int firstNumber = 3;
        int secondNumber = 15;
        int expectedResult = firstNumber - secondNumber;

        //WHEN
        int result = calculator.subtract(firstNumber, secondNumber);

        //THEN
        Assertions.assertEquals(expectedResult, result, "The subtract result should be equal to the expected result.");
    }
}
