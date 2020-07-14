package nowcode;

public class Solution_JZ51 {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] result = new int[length];
        int[] front = new int[length];
        int[] back = new int[length];

        front[0] = A[0];
        for (int i = 1; i < length - 1; i++) {
            front[i] = front[i - 1] * A[i];
        }

        back[length - 1] = A[length - 1];
        for (int i = length - 2; i >= 1; i--) {
            back[i] = back[i + 1] * A[i];
        }

        result[0] = back[1];
        result[length - 1] = front[length - 2];
        for (int i = 1; i < length - 1; i++) {
            result[i] = front[i - 1] * back[i + 1];
        }

        return result;
    }
}
