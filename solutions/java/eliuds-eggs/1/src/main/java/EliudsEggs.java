public class EliudsEggs {
    public int eggCount(int number) {

        int[] binary = new int[1000];
        int totalEggs = 0;

        int i = 0;
        while (number > 0) {
            binary[i] = number % 2;
            number = number / 2;
            i++;
        }

        for (int j = 0; j < binary.length; j++) {
            if (binary[j] == 1) {
                totalEggs++;
            }
        }

        return totalEggs;
    }
}
