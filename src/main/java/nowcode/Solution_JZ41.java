package nowcode;

import java.util.ArrayList;

public class Solution_JZ41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= (sum - 1) / 2; i++) {
            for (int j = i + 1; ; j++) {
                int total = (i + j) * (j - i + 1);
                if (total > 2 * sum) {
                    break;
                }
                if (total == 2 * sum) {
                    ArrayList<Integer> tar = new ArrayList<>();
                    for (int k = i; k <= j; k++) {
                        tar.add(k);
                    }
                    result.add(tar);
                }
            }
        }
        return result;
    }
}
