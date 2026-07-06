import java.util.regex.Pattern;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        Pattern digitsPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        int totalToCheck = 0;
        int totalDashes = 0;
        int multiplier = 10;

        if (stringToVerify.length() < 10) {
            return false;
        }

        for (int i = 0; i < stringToVerify.length(); i++) {

            String digit = stringToVerify.substring(i, i + 1);

            if ((i == stringToVerify.length() - 1) && digit.equals("X")) {
                totalToCheck = totalToCheck + 10 * multiplier;
                break;
            }

            if (digit.equals("-")) {
                totalDashes++;
                continue;
            }

            if (!digitsPattern.matcher(digit).matches()) {
                return false;
            } else {
                totalToCheck = totalToCheck + Integer.parseInt(digit) * multiplier;
                multiplier--;
            }
        }

        if ((stringToVerify.length() > 10) && (totalDashes == 0)) {
            return false;
        }

        return totalToCheck % 11 == 0;
    }
}
