import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class ResistorColorDuo {
    private static final Map<String, String> COLOR_MAP = new LinkedHashMap<>();

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

    int value(String[] colors) {
        StringBuilder result = new StringBuilder();
        for (String color : colors) {
            result.append(COLOR_MAP.get(color));
            if (result.length() == 2) {
                break;
            }
        }
        return Integer.parseInt(result.toString());
    }
}
