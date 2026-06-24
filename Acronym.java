import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {
    private final String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        if (phrase.contains(" - ")) {
            return Arrays.stream(phrase.split(" - | "))
                    .map(s -> s.substring(0, 1))
                    .map(String::toUpperCase)
                    .collect(Collectors.joining());
        } else if (phrase.contains("_")) {
            return Arrays.stream(phrase.split(" _|_ | "))
                    .map(s -> s.substring(0, 1))
                    .map(String::toUpperCase)
                    .collect(Collectors.joining());
        } else {
            return Arrays.stream(phrase.split("[ \\-]"))
                    .map(s -> s.substring(0, 1))
                    .map(String::toUpperCase)
                    .collect(Collectors.joining());
        }
    }
}