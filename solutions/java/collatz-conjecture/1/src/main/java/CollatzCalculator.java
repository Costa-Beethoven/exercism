class CollatzCalculator {

    int computeStepCount(int start) {

        if (start <= 0) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }

        int count = 0;
        while (start > 1) {

            if (start % 2 == 0) {
                count++;
                start /= 2;
            } else {
                count++;
                start = start*3 + 1;
            }
        }

        return count;
    }
}
