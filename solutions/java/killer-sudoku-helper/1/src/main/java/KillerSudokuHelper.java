import java.util.ArrayList;
import java.util.List;

public class KillerSudokuHelper {

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {

        List<List<Integer>> masterList = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        combinationsFactory(cageSum, cageSize, exclude, 1, currentCombination, masterList);

        return masterList;
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        return combinationsInCage(cageSum, cageSize, new ArrayList<>());
    }

    private void combinationsFactory(int cageSum, int cageSize, List<Integer> exclude,
                                     int startNumber, List<Integer> currentCombination, List<List<Integer>> masterList) {

        if (currentCombination.size() == cageSize) {

            if (cageSum == 0) {
                masterList.add(new ArrayList<>(currentCombination));
            }
            return;
        }

        for (int i = startNumber; i <= 9; i++) {

            if (exclude.contains(i)) {
                continue;
            }

            currentCombination.add(i);

            combinationsFactory(cageSum - i, cageSize, exclude, i + 1, currentCombination, masterList);

            currentCombination.removeLast();
        }
    }
}
