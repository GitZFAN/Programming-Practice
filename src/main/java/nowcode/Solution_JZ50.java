package nowcode;

import java.util.HashSet;

public class Solution_JZ50 {
    /**
     * @param numbers     an array of integers
     * @param length      the length of array numbers
     * @param duplication (Output) the duplicated number in the array number,
     *                    length of duplication array is 1,so using duplication[0] = ? in implementation;
     *                    Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
     * @return true if the input is valid, and there are some duplications in the array number otherwise false
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int number = numbers[i];
            if (hashSet.contains(number)) {
                duplication[0] = number;
                return true;
            } else {
                hashSet.add(number);
            }
        }
        return false;
    }
}
