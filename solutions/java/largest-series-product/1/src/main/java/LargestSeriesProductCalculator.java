import java.util.*;

class LargestSeriesProductCalculator {

    String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber;

        if (!inputNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {

        if (numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        int possibleCombinations = inputNumber.length() - numberOfDigits + 1;
        List<String> listOfCombinations = new ArrayList<>();
        List<Long> listOfMultiplications = new ArrayList<>();

        // Adding all possible combinations to a list
        for (int i = 0; i < possibleCombinations; i++) {
            String combination = inputNumber.substring(i, i + numberOfDigits);
            listOfCombinations.add(combination);
        }

        // Iterating through all possible combinations
        for (String listOfCombination : listOfCombinations) {

            long totalMultiplication;
            List<Long> digits = new ArrayList<>();

            // Iterating through all digits of each combination and wrapping them into a list
            for (int i = 0; i < numberOfDigits; i++) {

                // Isolating the digit
                long digit = Integer.parseInt(listOfCombination.substring(i, i+1));

                // Adding the digit to the digits list
                digits.add(digit);
            }

            // Multiplying all digits of the list
            totalMultiplication = digits.stream().reduce(1L, (a, b) -> a*b);

            // Adding the multiplication to the final list
            listOfMultiplications.add(totalMultiplication);
        }

        // Checking the largest element of the final list
        return Collections.max(listOfMultiplications);
    }
}
