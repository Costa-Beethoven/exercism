import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class IsogramChecker {

    boolean isIsogram(String phrase) {

        List<String> letters = new ArrayList<>();

        for (int i = 0; i < phrase.length(); i++) {
            String letter = phrase.substring(i, i + 1).toLowerCase();
            if (!letter.equals("-") && !letter.isBlank()) {
                letters.add(letter);
            }
        }
        List<String> duplicates = letters.stream()
                .filter(i -> Collections.frequency(letters, i) > 1).distinct().toList();

        return duplicates.isEmpty();

    }
}
