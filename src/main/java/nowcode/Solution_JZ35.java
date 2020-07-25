package nowcode;

public class Solution_JZ35 {

    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        Solution_JZ35 solution_jz35 = new Solution_JZ35();
        int inversePairs = solution_jz35.InversePairs(array);
        System.out.println(inversePairs);
    }

    public int InversePairs(int[] array) {
        int length = array.length;
        int[] backup = new int[length];
        return inversePairs(array, backup, 0, length - 1);
    }

    private int inversePairs(int[] array, int[] backup, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return 0;
        }
        int midIndex = (leftIndex + rightIndex) / 2;
        int leftInversePairs = inversePairs(array, backup, leftIndex, midIndex) % MOD;
        int rightInversePairs = inversePairs(array, backup, midIndex + 1, rightIndex) % MOD;
        int result = leftInversePairs + rightInversePairs;
        if (result > MOD) {
            result %= MOD;
        }

        // 将array中的数据导入backup中，然后归并排序到array中
        if (rightIndex + 1 - leftIndex >= 0) {
            System.arraycopy(array, leftIndex, backup, leftIndex, rightIndex + 1 - leftIndex);
        }

        // TODO 这里归并的过程需要重写
        int l = leftIndex;
        int r = midIndex + 1;
        int i = leftIndex;
        while (l <= midIndex && r <= rightIndex) {
            if (backup[l] < backup[r]) {
                array[i] = backup[l];
                l += 1;
            } else {
                array[i] = backup[r];
                r += 1;
                // 此时存在逆序对
                result += midIndex + 1 - l;
                if (result > MOD) {
                    result %= MOD;
                }
            }
            i += 1;
        }

        // 某一数组到达末端，将另一数组剩余部分都倒入新数组
        if (l > midIndex) {
            for (int j = r; j <= rightIndex; j++) {
                array[i] = backup[j];
                i += 1;
            }
        } else {
            for (int j = l; j <= midIndex; j++) {
                array[i] = backup[j];
                i += 1;
            }
        }

        return result;
    }

    /**
     * 遍历方法，时间复杂度为O(n^2)，超时
     */
    public int InversePairs1(int[] array) {
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    result += 1;
                }
            }
            if (result > MOD) {
                result %= MOD;
            }
        }
        return result;
    }
}
