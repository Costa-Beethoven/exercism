import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

class ResistorColorTrio {
    private static final Map<String, String> COLOR_MAP = new LinkedHashMap<>();
    private static final Map<String, String> ZEROS_MAP = new LinkedHashMap<>();

    static {
        COLOR_MAP.put("black", "0");
        COLOR_MAP.put("brown", "1");
        COLOR_MAP.put("red", "2");
        COLOR_MAP.put("orange", "3");
        COLOR_MAP.put("yellow", "4");
        COLOR_MAP.put("green", "5");
        COLOR_MAP.put("blue", "6");
        COLOR_MAP.put("violet", "7");
        COLOR_MAP.put("grey", "8");
        COLOR_MAP.put("white", "9");
    }

    static {
        ZEROS_MAP.put("black", "");
        ZEROS_MAP.put("brown", "0");
        ZEROS_MAP.put("red", "00");
        ZEROS_MAP.put("orange", "000");
        ZEROS_MAP.put("yellow", "0000");
        ZEROS_MAP.put("green", "00000");
        ZEROS_MAP.put("blue", "000000");
        ZEROS_MAP.put("violet", "0000000");
        ZEROS_MAP.put("grey", "00000000");
        ZEROS_MAP.put("white", "000000000");
    }

    String label(String[] colors) {
        StringBuilder resultWithNoZeros = new StringBuilder();

        for (String color : colors) {
            resultWithNoZeros.append(COLOR_MAP.get(color));
            if (resultWithNoZeros.length() == 2) {
                break;
            }
        }

        String zeros = ZEROS_MAP.get(colors[2]);
        String resultWithZeros = resultWithNoZeros + zeros;

        if (Objects.equals(colors[0], "black") && Objects.equals(colors[1], "black")) {
            return "0 ohms";
        } else if (Objects.equals(colors[0], "black")) {
            return resultWithZeros.substring(1) + " ohms";
        } else if (zeros.length() < 3 && !Objects.equals(colors[1], "black")) {
            return resultWithZeros + " ohms";
        } else if (zeros.length() == 2) {
            return resultWithZeros.substring(0, resultWithZeros.length()-3) + " kiloohms";
        } else if (zeros.length() == 3) {
            return resultWithNoZeros + " kiloohms";
        } else if (zeros.length() < 6) {
            return resultWithZeros.substring(0, resultWithZeros.length()-3) + " kiloohms";
        } else if (zeros.length() == 6) {
            return resultWithNoZeros + " megaohms";
        } else if (zeros.length() < 9) {
            return resultWithZeros.substring(0, resultWithZeros.length()-6) + " megaohms";
        } else if (zeros.length() == 9) {
            return resultWithNoZeros + " gigaohms";
        } else {
            return resultWithZeros.substring(0, resultWithZeros.length()-9) + " gigaohms";
        }
    }
}
