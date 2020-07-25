package nowcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution_JZ29 {

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        Solution_JZ29 solution_jz29 = new Solution_JZ29();
        ArrayList<Integer> list = solution_jz29.GetLeastNumbers_Solution(array, 4);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k == 0 || k > input.length) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> result = new ArrayList<>(k);

        LinkedList<Integer> list = new LinkedList<>();
        for (int integer : input) {
            if (list.size() == k) {
                if (integer < list.getLast()) {
                    for (int i = 0; i < list.size(); i++) {
                        if (integer < list.get(i)) {
                            list.add(i, integer);
                            list.removeLast();
                            break;
                        }
                    }
                }
            } else {
                int i = 0;
                for (; i < list.size(); i++) {
                    if (integer < list.get(i)) {
                        list.add(i, integer);
                        break;
                    }
                }
                if (i == list.size()) {
                    list.add(integer);
                }
            }
        }

        result.addAll(list);
        return result;
    }
}
