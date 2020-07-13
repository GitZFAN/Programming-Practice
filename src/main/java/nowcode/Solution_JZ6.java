package nowcode;

public class Solution_JZ6 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        return minNumber(array, 0, array.length - 1);
    }

    private int minNumber(int[] array, int from, int end) {
        if (from == end) {
            return array[end];
        }
        if (from + 1 == end) {
            return array[end];
        }
        int mid = (from + end) / 2;
        if (array[mid] >= array[from]) {
            return minNumber(array, mid, end);
        }
        if (array[mid] <= array[end]) {
            return minNumber(array, from, mid);
        }
        return 0;
    }
}
