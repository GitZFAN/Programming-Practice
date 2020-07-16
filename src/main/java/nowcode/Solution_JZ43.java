package nowcode;

public class Solution_JZ43 {
    public String LeftRotateString(String str, int n) {
        if ("".equals(str.trim()) || n == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
