import java.util.ArrayList;
import java.util.List;

class Sieve {

    private final int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {

        List<Integer> markedNumbers = new ArrayList<>(List.of());
        List<Integer> primes = new ArrayList<>(List.of());

        for (int i = 2; i <= maxPrime; i++) {
            if (!markedNumbers.contains(i)) {
                primes.add(i);
                for (int j = i * i; j <= maxPrime; j += i) {
                    markedNumbers.add(j);
                }
            }
        }

        return primes;
    }
}
