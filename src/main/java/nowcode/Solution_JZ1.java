package nowcode;

public class Solution_JZ1 {
    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int[] ints = array[i];
            if (ints.length == 0) {
                continue;
            }
            if (target < ints[0] || target > ints[ints.length-1]) {
                continue;
            }

            boolean isFound = halfFind(target, ints, 0, ints.length - 1);
            if (isFound) {
                return true;
            }
        }
        return false;
    }

    private boolean halfFind(int target, int[] ints, int low, int high) {
        if (low > high) {
            return false;
        }

        int mid = (low + high) / 2;
        if (target == ints[mid]) {
            return true;
        }
        if (target > ints[mid]) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
        return halfFind(target, ints, low, high);
    }


}
