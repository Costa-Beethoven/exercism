class Proverb {

    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {

        if (words.length == 0) {
            return "";
        }

        String finalSentence = "And all for the want of a " + words[0] + ".";
        if (words.length == 1) {
            return finalSentence;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            result.append("For want of a ").append(words[i]).append(" the ").append(words[(i+1)%words.length]).append(" was lost.\n");
        }
        result.append(finalSentence);

        return result.toString();
    }

}
