import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {

        List<Signal> result = new ArrayList<>();

        final String reversing = getString(number);

        if (reversing.charAt(0) == '1') {
            result.add(Signal.WINK);
        }
        if (reversing.charAt(1) == '1') {
            result.add(Signal.DOUBLE_BLINK);
        }
        if (reversing.charAt(2) == '1') {
            result.add(Signal.CLOSE_YOUR_EYES);
        }
        if (reversing.charAt(3) == '1') {
            result.add(Signal.JUMP);
        }
        if (reversing.charAt(4) == '1') {
            result = result.reversed();
        }

        return result;
    }

    private static String getString(int number) {
        String bina = Integer.toBinaryString(number);
        StringBuilder sb = new StringBuilder(bina);
        String reversing = String.valueOf(sb.reverse());

        if (bina.length() == 1) {
            reversing = reversing + "0000";
        } else if (bina.length() == 2) {
            reversing = reversing + "000";
        } else if (bina.length() == 3) {
            reversing = reversing + "00";
        } else if (bina.length() == 4) {
            reversing = reversing + "0";
        }
        return reversing;
    }
}
