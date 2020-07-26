package nowcode;

import java.util.ArrayList;

public class Solution_JZ13 {
    public void reOrderArray(int[] array) {
        ArrayList<Integer> odd = new ArrayList<>(array.length);
        ArrayList<Integer> even = new ArrayList<>(array.length);
        for (int a : array) {
            if (a % 2 == 0) {
                even.add(a);
            } else {
                odd.add(a);
            }
        }
        int index = 0;
        for (Integer integer : odd) {
            array[index] = integer;
            index += 1;
        }
        for (Integer integer : even) {
            array[index] = integer;
            index += 1;
        }
    }
}
