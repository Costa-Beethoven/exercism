import java.util.ArrayList;
import java.util.List;

class PrimeCalculator {

    int nth(int nth) {

        if (nth == 0) {
            throw new IllegalArgumentException();
        }

        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        for (int n = 3; n <= 104743; n++) {

            boolean notPrime = false;

            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    notPrime = true;
                    break;
                }
            }

            if (!notPrime) {
                primes.add(n);
            }
        }

        return primes.get(nth-1);
    }
}
