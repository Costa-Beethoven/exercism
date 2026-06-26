class RaindropConverter {

    String convert(int number) {
        String divisibleBy3 = "Pling";
        String divisibleBy5 = "Plang";
        String divisibleBy7 = "Plong";

        if (number % (3 * 5 * 7) == 0) {
            return divisibleBy3 + divisibleBy5 + divisibleBy7;
        } else if (number % (5 * 7) == 0) {
            return divisibleBy5 + divisibleBy7;
        } else if (number % (3 * 7) == 0) {
            return divisibleBy3 + divisibleBy7;
        } else if (number % (3 * 5) == 0) {
            return divisibleBy3 + divisibleBy5;
        } else if (number % 7 == 0) {
            return divisibleBy7;
        } else if (number % 5 == 0) {
            return divisibleBy5;
        } else if (number % 3 == 0) {
            return divisibleBy3;
        } else {
            return String.valueOf(number);
        }
    }
}
