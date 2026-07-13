import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class LuhnValidator {

    boolean isValid(String candidate) {

        String candidateWithoutSpaces = candidate.replaceAll("\\s", "");
        List<Integer> evenDigitsList = new ArrayList<>();
        List<Integer> oddDigitsList = new ArrayList<>();
        int evenSum;
        int oddSum;
        int totalSum;

        // Checking if the input is 0 or 1 so that returns false
        if ((candidateWithoutSpaces.length() == 1) && (Integer.parseInt(candidateWithoutSpaces)) <= 1) {
            return false;
        }

        // Checking if the input has any letter so that returns false
        if (!candidateWithoutSpaces.chars().allMatch(Character::isDigit)) {
            return false;
        }

        // Creation of the even-index digits list
        for (int i = candidateWithoutSpaces.length() - 2; i >= 0; i = i - 2) {

            String digit = candidateWithoutSpaces.substring(i, i + 1);
            int numericDigit = Integer.parseInt(digit);
            if (numericDigit * 2 > 9) {
                numericDigit = numericDigit*2 - 9;
            } else {
                numericDigit *= 2;
            }

            evenDigitsList.add(numericDigit);
        }

        // Creation of the odd-index digits list
        for (int i = candidateWithoutSpaces.length() - 1; i >= 0; i = i - 2) {

            String digit = candidateWithoutSpaces.substring(i, i + 1);
            int numericDigit = Integer.parseInt(digit);
            oddDigitsList.add(numericDigit);
        }

        evenSum = evenDigitsList.stream().reduce(0, Integer::sum);
        oddSum = oddDigitsList.stream().reduce(0, Integer::sum);
        totalSum = evenSum + oddSum;

        return totalSum%10 == 0;
    }
}
