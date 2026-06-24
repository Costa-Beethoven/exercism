class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        int digit = numberToCheck % 10;

        int numberOfDigits;
        if (numberToCheck == 0) {
            numberOfDigits = 1;
        } else {
            numberOfDigits = (int) (Math.log10(numberToCheck) + 1);
        }

        int result = (int) Math.pow(digit, numberOfDigits);
        int dividedNumber = numberToCheck;

        if (numberOfDigits > 1) {
            while (dividedNumber > 0) {
                dividedNumber = dividedNumber / 10;
                digit = dividedNumber % 10;
                result = (int) Math.pow(digit, numberOfDigits) + result;
            }
        }

        return (result == numberToCheck);
    }
}
