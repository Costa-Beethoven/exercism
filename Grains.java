import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(int square) {
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }

        BigInteger two = BigInteger.valueOf(2);
        return two.pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        BigInteger total = BigInteger.valueOf(0);
        for (int square = 1; square < 65; square++) {
            total = total.add(grainsOnSquare(square));
        }
        return total;
    }

}
