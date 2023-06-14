package org.example;

public class StringCalculatorZero {

    int addInvokeCount;

    public int getCalledCount() {
        return addInvokeCount;
    }

    public int add(String numbers) {
        addInvokeCount++;
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String[] args = null;
            if (numbers.startsWith("//")) {
                args = splitArgumentWithCustomDelimiter(numbers);
            } else {
                args = splitArgumentWithDefaultDelimiters(numbers);
            }
            checkNegativeNumbers(args);
            return addArguments(args);
        }
    }

    private String[] splitArgumentWithDefaultDelimiters(String numbers) {
        return numbers.split("[,\n]");
    }

    private String[] splitArgumentWithCustomDelimiter(String numbers) {
        String delimiter = numbers.charAt(2)+"";
        numbers = numbers.substring(4);
        return numbers.split(delimiter);
    }


    private void checkNegativeNumbers(String[] args) {
        StringBuilder negativeNumbers = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (Integer.parseInt(args[i]) <0) {
                negativeNumbers.append(Integer.parseInt(args[i]) + ",");
            }
        }
        if (!negativeNumbers.toString().isEmpty()) {
            throw new RuntimeException("negatives not allowed: " + negativeNumbers.substring(0, negativeNumbers.length() - 1));
        }
    }

    private int addArguments( String[] args) {
        int total = 0;
        for (int i = 0; i < args.length; i++) {
            if (Integer.parseInt(args[i]) <= 1000) {
                total += Integer.parseInt(args[i]);
            }
        }
        return total;
    }
}
