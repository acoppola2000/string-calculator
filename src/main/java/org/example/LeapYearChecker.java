package org.example;

public class LeapYearChecker {

    public Boolean isLeap(int year) {
        if (isDivisibleFor400(year)) {
            return true;
        }
        if (!isDivisibleFor400(year) && isDivisibleFor100(year)) {
            return false;
        }
        if (isDivisibleFor4(year) && !isDivisibleFor100(year)) {
            return true;
        }
        if (!isDivisibleFor4(year)) {
            return false;
        }
        return null;
    }

    private boolean isDivisibleFor100(int number)  {
        return (number%100 == 0);
    }

    private boolean isDivisibleFor400(int number)  {
        return (number%400 == 0);
    }

    private boolean isDivisibleFor4(int number)  {
        return (number%4 == 0);
    }

}
