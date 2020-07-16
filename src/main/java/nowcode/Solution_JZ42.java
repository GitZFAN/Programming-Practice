package nowcode;

import java.util.ArrayList;

public class Solution_JZ42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>(2);
        int left = 0;
        int right = array.length - 1;

        int mul = Integer.MAX_VALUE;

        while (left < right) {
            if (array[left] + array[right] == sum) {
                if (array[left] * array[right] < mul) {
                    mul = array[left] * array[right];
                    if (result.size() == 0) {
                        result.add(array[left]);
                        result.add(array[right]);
                    } else {
                        result.set(0, array[left]);
                        result.set(1, array[right]);
                    }
                }
                left += 1;
            }
            if (array[left] + array[right] > sum) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        return result;
    }
}
