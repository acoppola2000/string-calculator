package org.example;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LeapYearCheckerTest {

    @Test
    void aYearDivisibleFor400IsLeap() {
        //ARRANGE
        LeapYearChecker checker = new LeapYearChecker();
        int year = 3 * 400;

        //ACT
        boolean res = checker.isLeap(year);

        //ASSERT
        assertThat(res, equalTo(true));
    }

    //All years divisible by 100 but not by 400 are NOT leap years

    @Test
    void aYearDivisibleFor100ButNotFor400IsNotLeap() {
        //ARRANGE
        LeapYearChecker checker = new LeapYearChecker();
        int year = 100;

        //ACT
        boolean res = checker.isLeap(year);

        //ASSERT
        assertThat(res, equalTo(false));
    }

    @Test
    void aYearDivisibleFor4ButNotFor100IsLeap() {
        //ARRANGE
        LeapYearChecker checker = new LeapYearChecker();
        int year = 2016;

        //ACT
        boolean res = checker.isLeap(year);

        //ASSERT
        assertThat(res, equalTo(true));
    }

    @Test
    void aYearNotDivisibleFor4IsNoLeap() {
        //ARRANGE
        LeapYearChecker checker = new LeapYearChecker();
        int year = 2018;

        //ACT
        boolean res = checker.isLeap(year);

        //ASSERT
        assertThat(res, equalTo(false));
    }

}
