package org.example;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;

public class StringCalculatorZeroTest {

    @Test
    void addingEmptyString() {
        //ARRANGE
        StringCalculatorZero calculator = new StringCalculatorZero();
        String input = "";
        //ACT
        int res = calculator.add(input);
        //ASSERT
        assertThat(res, equalTo(0));
    }

    @Test
    void addingOneNumber() {
        //ARRANGE
        StringCalculatorZero calculator = new StringCalculatorZero();
        String input = "1";
        //ACT
        int res = calculator.add(input);
        //ASSERT
        assertThat(res, equalTo(1));
    }

    @Test
    void addingTwoNumbers() {
        //ARRANGE
        StringCalculatorZero calculator = new StringCalculatorZero();
        String input = "1,2";
        //ACT
        int res = calculator.add(input);
        //ASSERT
        assertThat(res, equalTo(3));
    }

    @Test
    void addingUnknownNumbers() {
        //ARRANGE
        StringCalculatorZero calculator = new StringCalculatorZero();
        String input = "7,2,5,6,10";
        //ACT
        int res = calculator.add(input);
        //ASSERT
        assertThat(res, equalTo(30));
    }

    @Test
    void addingUnknownNumbersWithNewLineSeparator() {
        //ARRANGE
        StringCalculatorZero calculator = new StringCalculatorZero();
        String input = "7\n2,5";
        //ACT
        int res = calculator.add(input);
        //ASSERT
        assertThat(res, equalTo(14));
    }

    @Test
    void declareCustomDelimiter() {
        //ARRANGE
        StringCalculatorZero calculator = new StringCalculatorZero();
        String input = "//;\n1;2";
        //ACT
        int res = calculator.add(input);
        //ASSERT
        assertThat(res, equalTo(3));
    }

    @Test
    void declareCustomDelimiterThree() {
        //ARRANGE
        StringCalculatorZero calculator = new StringCalculatorZero();
        String input = "//x\n1x2x5";
        //ACT
        int res = calculator.add(input);
        //ASSERT
        assertThat(res, equalTo(8));
    }

    @Test
    void negativeNumberIsInvalid() {
        //ARRANGE
        StringCalculatorZero calculator = new StringCalculatorZero();
        String input = "//x\n1x-2x5";
        Exception expectedException = null;
        //ACT
        try {
            calculator.add(input);
        } catch (Exception e) {
            expectedException = e;
        }

        //ASSERT
        assertThat(expectedException, notNullValue());
        assertThat(expectedException.getMessage(), equalToIgnoringCase("negatives not allowed: " + "-2"));

    }

    @Test
    void manyNegativeNumbersAreInvalid() {
        //ARRANGE
        StringCalculatorZero calculator = new StringCalculatorZero();
        String input = "//x\n1x-2x5x-3x6";
        Exception expectedException = null;
        //ACT
        try {
            calculator.add(input);
        } catch (Exception e) {
            expectedException = e;
        }

        //ASSERT
        assertThat(expectedException, notNullValue());
        assertThat(expectedException.getMessage(), equalToIgnoringCase("negatives not allowed: " + "-2,-3"));

    }


    @Test
    void canCountAddInvokes() {
        //ARRANGE
        StringCalculatorZero calculator = new StringCalculatorZero();
        //ACT
        calculator.add("2,5,6");
        calculator.add("4");
        calculator.add("7,9");
        int addInvokeCount = calculator.getCalledCount();
        //ASSERT
        assertThat(addInvokeCount, equalTo(3));
    }

    @Test
    void ignoreNumbersTooBig() {
        //ARRANGE
        StringCalculatorZero calculator = new StringCalculatorZero();
        String input = "2,1001,3";
        //ACT
        int res = calculator.add(input);
        //ASSERT
        assertThat(res, equalTo(5));
    }
}
