package jobsCodeExam2020.sougou;

/**
 * @author 13585
 * @date 2020-09-25
 */
public class Solution2 {
    public static void main(String[] args) {
        String[] s1 = {"1101", "1010", "1111", "1110"};
        String[] s2 = {"ABCD", "EFGH", "IJKL", "MNPQ"};
        Solution2 solution2 = new Solution2();
        String s = solution2.rotatePassword(s1, s2);
        System.out.println(s);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回一行字符串，表示原文。
     *
     * @param s1 string字符串一维数组 N*N的01矩阵，表示解密纸，0表示透明，1表示涂黑
     * @param s2 string字符串一维数组 字符矩阵，表示密文
     * @return string字符串
     */
    public String rotatePassword(String[] s1, String[] s2) {
        // write code here
        if (s1 == null || s1.length == 0) {
            return "";
        }

        int length = s1.length;
        int[][] ints = new int[length][length];

        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s1[i].length(); j++) {
                if (s1[i].charAt(j) == '1') {
                    ints[i][j] = 1;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        getStr(s2, ints, stringBuilder);

        for (int i = 0; i < 3; i++) {
            ints = transfer(ints);
            getStr(s2, ints, stringBuilder);
        }

        return stringBuilder.toString();
    }

    private void getStr(String[] s2, int[][] ints, StringBuilder stringBuilder) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] == 0) {
                    stringBuilder.append(s2[i].charAt(j));
                }
            }
        }
    }

    private int[][] transfer(int[][] ints) {
        int length = ints.length;
        int[][] ints1 = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] == 1) {
                    ints1[j][length - 1 - i] = ints[i][j];
                }
            }
        }
        return ints1;
    }


}
