package nowcode;

public class Solution_JZ21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int[] status = new int[pushA.length];
        int top = -1;

        for (int integer : popA) {
            int index = 0;
            for (; index < pushA.length; index++) {
                if (pushA[index] == integer) {
                    break;
                }
            }
            if (index == pushA.length) {
                return false;
            }

            if (index < top) {
                return false;
            }

            status[index] = 1;
            int cur = index - 1;
            for (; cur >= 0; cur--) {
                if (status[cur] == 0) {
                    break;
                }
            }
            top = cur;
        }
        return true;
    }
}
