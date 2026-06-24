class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = 0;
        for (int i = 0; i < input; i++) {
            sum = sum + i+1;
        }
        return (int) Math.pow(sum, 2);
    }

    int computeSumOfSquaresTo(int input) {
        int sumOfSquares = 0;
        for (int i = 0; i < input; i++) {
            sumOfSquares = sumOfSquares + (int) (Math.pow(i+1, 2));
        }
        return sumOfSquares;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }
}
