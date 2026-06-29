import java.util.HashMap;
import java.util.Map;

class Scrabble {

    String word;
    int points = 0;

    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        Map<String, Integer> scoring = new HashMap<>();
        scoring.put("A", 1);
        scoring.put("E", 1);
        scoring.put("I", 1);
        scoring.put("O", 1);
        scoring.put("U", 1);
        scoring.put("L", 1);
        scoring.put("N", 1);
        scoring.put("R", 1);
        scoring.put("S", 1);
        scoring.put("T", 1);
        scoring.put("D", 2);
        scoring.put("G", 2);
        scoring.put("B", 3);
        scoring.put("C", 3);
        scoring.put("M", 3);
        scoring.put("P", 3);
        scoring.put("F", 4);
        scoring.put("H", 4);
        scoring.put("V", 4);
        scoring.put("W", 4);
        scoring.put("Y", 4);
        scoring.put("K", 5);
        scoring.put("J", 8);
        scoring.put("X", 8);
        scoring.put("Q", 10);
        scoring.put("Z", 10);

        if (word.length() == 1) {
            return scoring.get(word.toUpperCase());
        } else {
            for (int i = 0; i < word.length(); i++) {
                points += scoring.get((word.substring(i, i + 1)).toUpperCase());
            }
            return points;
        }
    }
}