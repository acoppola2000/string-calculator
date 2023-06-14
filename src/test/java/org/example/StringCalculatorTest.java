package org.example;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StringCalculatorTest {

    @Test
    void addingEmptyString() {
        //ARRANGE
        StringCalculator calculator = new StringCalculator();
        String input = "";
        //ACT
        int res = calculator.add(input);
        //ASSERT
        assertThat(res, equalTo(0));
    }

}
