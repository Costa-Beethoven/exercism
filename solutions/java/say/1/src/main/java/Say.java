import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Say {

    public String say(long number) {

        Map<Long, String> conversion = new HashMap<>();
        conversion.put(0L, "zero");
        conversion.put(1L, "one");
        conversion.put(2L, "two");
        conversion.put(3L, "three");
        conversion.put(4L, "four");
        conversion.put(5L, "five");
        conversion.put(6L, "six");
        conversion.put(7L, "seven");
        conversion.put(8L, "eight");
        conversion.put(9L, "nine");
        conversion.put(10L, "ten");
        conversion.put(11L, "eleven");
        conversion.put(12L, "twelve");
        conversion.put(13L, "thirteen");
        conversion.put(14L, "fourteen");
        conversion.put(15L, "fifteen");
        conversion.put(16L, "sixteen");
        conversion.put(17L, "seventeen");
        conversion.put(18L, "eighteen");
        conversion.put(19L, "nineteen");
        conversion.put(20L, "twenty");
        conversion.put(30L, "thirty");
        conversion.put(40L, "forty");
        conversion.put(50L, "fifty");
        conversion.put(60L, "sixty");
        conversion.put(70L, "seventy");
        conversion.put(80L, "eighty");
        conversion.put(90L, "ninety");
        conversion.put(100L, "hundred");
        conversion.put(1000L, "thousand");
        conversion.put(1000000L, "million");
        conversion.put(1000000000L, "billion");

        long unit = number % 10;
        long tens = number % 100 - unit;
        long hundreds = number % 1000 - tens - unit;
        long thousands = number % 10000 - hundreds - tens - unit;
        long millions = number % 10000000 - thousands - hundreds - tens - unit;
        long billions = number % 1000000000 - millions - thousands - hundreds - tens - unit;

        if (number < 0 || number > 999999999999L) {
            throw new IllegalArgumentException();
        }

        if (conversion.containsKey(number) && (number < 100)) {
            return conversion.get(number);
        } else if (number == 100 || number == 1000 || number == 1000000 || number == 1000000000) {
            return "one " + conversion.get(number);
        } else if (number < 100) {
            return (conversion.get(tens) + "-" + conversion.get(unit));
        } else if (number < 1000 && number%100==0) {
            return conversion.get(number/100) + " " + conversion.get(100L);
        } else if (number < 1000) {
            return (conversion.get(number/100) + " " + conversion.get(100L) + " " + conversion.get(tens) + "-" + conversion.get(unit));
        } else if (number < 1000000 && number%1000==0) {
            return conversion.get(number/1000) + " " + conversion.get(1000L);
        } else if (number < 1000000) {
            return (conversion.get(number/1000) + " " + conversion.get(1000L) + " " + conversion.get((number-1000)/100) + " " + conversion.get(100L) + " " + conversion.get(tens) + "-" + conversion.get(unit));
        } else if (number < 1000000000) {
            return (conversion.get(number/1000000)) + " " + conversion.get(1000000L) + " " + conversion.get((number-1000000)/1000) + " " + conversion.get(1000L) + " " + conversion.get((number-1000000-2000)/100) + " " + conversion.get(100L) + " " + conversion.get(tens) + "-" + conversion.get(unit);
        } else {
            return (conversion.get((number/1000000000)/100) + " " + conversion.get(100L) + " " + conversion.get((number/1000000000)%100 - (number/1000000000)%10) + "-" + conversion.get((number/1000000000)%10) + " " + conversion.get(1000000000L) + " " +
                    conversion.get(((number/1000000)%1000)/100) + " " + conversion.get(100L) + " " + conversion.get((number/1000000)%100 - (number/1000000)%10) + "-" + conversion.get((number/1000000)%10) + " " + conversion.get(1000000L) + " " +
                    conversion.get(((number/1000)%1000)/100) + " " + conversion.get(100L) + " " + conversion.get((number/1000)%100 - (number/1000)%10) + "-" + conversion.get((number/1000)%10) + " " + conversion.get(1000L) + " " +
                    conversion.get((number%1000)/100)) + " " + conversion.get(100L) + " " + conversion.get(tens) + "-" + conversion.get(unit);
        }
    }
}
