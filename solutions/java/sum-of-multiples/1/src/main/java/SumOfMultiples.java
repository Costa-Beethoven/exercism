import java.util.HashSet;
import java.util.Set;

class SumOfMultiples {

    int number;
    int[] set;
    int sum;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {

        Set<Integer> multiples = new HashSet<>();

        for (int setElement : set) {

            if (setElement == 0) {
                continue;
            }

            for (int currentNumber = setElement; currentNumber < number; currentNumber += setElement) {
                multiples.add(currentNumber);
            }

        }

        for (int multiple : multiples) {
            sum += multiple;
        }

        return sum;

    }

}
