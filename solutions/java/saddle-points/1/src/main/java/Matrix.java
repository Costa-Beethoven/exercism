import java.util.List;
import java.util.Set;

class Matrix {

    private final List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {

        Set<MatrixCoordinate> result = new java.util.HashSet<>(Set.of());
        int rowMax;
        int colMin;

        for (int rowIndex = 0; rowIndex < values.size(); rowIndex++) {

            rowMax = values.get(rowIndex).stream()
                    .max(Integer::compareTo).orElse(0);

            for (int colIndex = 0; colIndex < values.get(rowIndex).size(); colIndex++) {

                int currentValue = values.get(rowIndex).get(colIndex);
                int finalColIndex = colIndex;

                colMin = values.stream()
                        .map(row -> row.get(finalColIndex))
                        .min(Integer::compareTo).orElse(0);

                if (currentValue == rowMax && currentValue == colMin) {
                    result.add(new MatrixCoordinate(rowIndex + 1, colIndex + 1));
                }
            }
        }

        return result;
    }
}
