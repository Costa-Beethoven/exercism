import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Matrix {

    String matrixAsString;

    Matrix(String matrixAsString) {
        this.matrixAsString = matrixAsString;
    }

    int[] getRow(int rowNumber) {

        String[] splitBrokenLines = matrixAsString.split("\n");
        String expectedRow = splitBrokenLines[rowNumber - 1];
        String[] expectedRowArray = expectedRow.split("\\s");
        int[] resultRow = new int[expectedRowArray.length];

        for (int i = 0; i < expectedRowArray.length; i++) {
            resultRow[i] = Integer.parseInt(expectedRowArray[i]);
        }

        return resultRow;
    }

    int[] getColumn(int columnNumber) {

        String[] splitBrokenLines = matrixAsString.split("\n");
        List<Integer> expectedElements = new ArrayList<>();

        for (String brokenLine : splitBrokenLines) {
            String[] rowElements = brokenLine.trim().split("\\s+");
            expectedElements.add(Integer.parseInt(rowElements[columnNumber - 1]));
        }

        int[] result = new int[expectedElements.size()];
        for (int i = 0; i < expectedElements.size(); i++) {
            result[i] = expectedElements.get(i);
        }

        return result;

    }
}
