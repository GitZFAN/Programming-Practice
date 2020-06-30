package nowcode;

public class Solution_JZ67 {

    public static void main(String[] args) {
        Solution_JZ67 jz67 = new Solution_JZ67();
        int rope = jz67.cutRope(8);
        System.out.println(rope);
    }

    public int cutRope(int target) {
        int[] results = new int[target+1];
        results[1] = 1;
        results[2] = 1;
        for (int i = 3; i <= target; i++) {
            int tempMax = 1;
            for (int j = 1; j <= i/2; j++) {
                int res1 = j * (i - j);
                int res2 = j * results[i - j];
                int res = Math.max(res1, res2);
                if (res > tempMax) {
                    tempMax = res;
                }
            }
            results[i] = tempMax;
            System.out.println("len:" + i + ", result:" + results[i]);
        }
        return results[target];
    }
}
