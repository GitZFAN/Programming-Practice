package nowcode;

public class Solution_JZ46 {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0) {
            return -1;
        }

        int[] children = new int[n];

        /**
         * 非递归解法
         */
        /*int remain = n;
        int cur = 0;
        for (int i = 0; ; i++) {
            if (i == children.length) {
                i = 0;
            }
            if (remain == 1) {
                break;
            }
            if (children[i] == 0) {
                if (cur == m-1) {
                    children[i] = 1;
                    remain -= 1;
                    cur = 0;
                } else {
                    cur += 1;
                }
            }
        }

        for (int i = 0; i < children.length; i++) {
            if (children[i] == 0) {
                return i;
            }
        }

        return -1;
        */

        /**
         * 递归方法
         */
        return lastRemain(children, 0, n, m);

    }

    private int lastRemain(int[] children, int from, int n, int m) {
        if (n == 1) {
            for (int i = 0; i < children.length; i++) {
                if (children[i] == 0) {
                    return i;
                }
            }
        }

        int cur = 0;
        for (int i = from; ; i++) {
            if (i == children.length) {
                i = 0;
            }
            if (children[i] == 0) {
                if (cur == m - 1) {
                    children[i] = 1;
                    return lastRemain(children, i + 1, n - 1, m);
                } else {
                    cur += 1;
                }
            }
        }

    }

}
