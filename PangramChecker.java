public class PangramChecker {

    public boolean isPangram(String input) {
        input = input.toLowerCase();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!input.contains(String.valueOf(ch))) {
                return false;
            }
        }
        return true;
    }
}
