package nowcode;

public class Solution_JZ52 {

    public static void main(String[] args) {

    }

    /**
     * 字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     */
    public boolean match(char[] str, char[] pattern) {

        int sIndex = 0;
        int pIndex = 0;

        return matchCore(str, sIndex, pattern, pIndex);
    }

    private boolean matchCore(char[] str, int sIndex, char[] pattern, int pIndex) {
        // 有效性检验：pattern到尾，若str也到尾，匹配成功；否则匹配失败。
        if (pIndex == pattern.length) {
            return sIndex == str.length;
        }

        // 判断 pattern 的第2个是不是'*'
        if ((pIndex + 1 < pattern.length) && pattern[pIndex + 1] == '*') {
            if (sIndex != str.length) {
                if (str[sIndex] == pattern[pIndex] || pattern[pIndex] == '.') {
                    return matchCore(str, sIndex, pattern, pIndex + 2) ||
                            matchCore(str, sIndex + 1, pattern, pIndex);
                } else {
                    return matchCore(str, sIndex, pattern, pIndex + 2);
                }
            } else {
                return matchCore(str, sIndex, pattern, pIndex + 2);
            }
        } else {
            if (sIndex != str.length) {
                if (str[sIndex] == pattern[pIndex] || pattern[pIndex] == '.') {
                    return matchCore(str, sIndex + 1, pattern, pIndex + 1);
                }
            }
        }

        return false;
    }
}
