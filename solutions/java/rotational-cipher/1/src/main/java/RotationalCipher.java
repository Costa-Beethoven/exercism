class RotationalCipher {

    private final int shiftKey;
    private final String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    private final String alphabetUpper = alphabetLower.toUpperCase();

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {

        String letter;
        int letterValue;
        String newLetter;
        int newLetterValue;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            letter = data.substring(i, i + 1);
            if (alphabetLower.contains(letter)) {
                letterValue = alphabetLower.indexOf(letter);
                newLetterValue = (letterValue + shiftKey) % 26;
                newLetter = alphabetLower.substring(newLetterValue, newLetterValue + 1);
                result.append(newLetter);
            } else if (alphabetUpper.contains(letter)) {
                letterValue = alphabetUpper.indexOf(letter);
                newLetterValue = (letterValue + shiftKey) % 26;
                newLetter = alphabetUpper.substring(newLetterValue, newLetterValue + 1);
                result.append(newLetter);
            } else {
                result.append(letter);
            }
        }

        return result.toString();

    }
}
