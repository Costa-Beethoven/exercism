object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        if (start <= 0) {
            throw IllegalArgumentException("Input must be a positive integer.")
        }

        var steps = 0
        var current = start

        while (current != 1) {

            current = if (current % 2 == 0) {
                current / 2
            } else {
                3 * current + 1
            }

            steps++
        }

        return steps
    }
}
