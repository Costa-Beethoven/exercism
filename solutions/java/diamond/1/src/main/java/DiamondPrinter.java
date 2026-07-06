import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {

        List<String> diamond = new ArrayList<>();
        String abc = "abcdefghijklmnopqrstuvwxyz";
        final int maxIndex = abc.indexOf(String.valueOf(a).toLowerCase()) + 1;

        if (a == 'A') {
            return Collections.singletonList("A");
        }

        for (int i = 1; i < maxIndex; i++) {
            String letter = abc.substring(i - 1, i).toUpperCase();

            String outerSpaces = " ".repeat(maxIndex - i);
            if (i == 1) {
                diamond.add(outerSpaces + letter + outerSpaces);
            } else {
                String innerSpaces = " ".repeat((i-1)*2 - 1);
                diamond.add(outerSpaces + letter + innerSpaces + letter + outerSpaces);
            }
        }

        String maxLetter = abc.substring(maxIndex - 1, maxIndex).toUpperCase();
        String middleInnerSpaces = " ".repeat((maxIndex - 1)*2 - 1);
        String middleLine = maxLetter + middleInnerSpaces + maxLetter;
        diamond.add(middleLine);

        for (int j = maxIndex - 1; j >= 1; j--) {
            String letter = abc.substring(j - 1, j).toUpperCase();

            String outerSpaces = " ".repeat(maxIndex - j);
            if (j == 1) {
                diamond.add(outerSpaces + letter + outerSpaces);
            } else {
                String innerSpaces = " ".repeat((j-1)*2 - 1);
                diamond.add(outerSpaces + letter + innerSpaces + letter + outerSpaces);
            }
        }

        return diamond;
    }
}
