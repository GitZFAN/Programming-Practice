package nowcode;

public class Solution_JZ31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '1') {
                    count += 1;
                }
            }
        }
        return count;
    }
}
