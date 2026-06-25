class NaturalNumber {

    int number;

    NaturalNumber(int number) {
        this.number = number;
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
    }

    Classification getClassification() {

        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }

        if (number == sum) {
            return Classification.PERFECT;
        } else if (number < sum) {
            return Classification.ABUNDANT;
        } else {
            return Classification.DEFICIENT;
        }
    }
}
