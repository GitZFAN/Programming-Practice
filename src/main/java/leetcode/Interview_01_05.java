package leetcode;

/**
 * 面试题 01.05. 一次编辑
 *
 * @author fzhang
 * @date 2020-10-14
 */
public class Interview_01_05 {
    /**
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
     * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     *
     * @param first  第一个字符串
     * @param second 第二个字符串
     * @return 它们是否只需要一次(或者零次)编辑
     */
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }

        int length1 = first.length();
        int length2 = second.length();
        int abs = Math.abs(length1 - length2);
        if (abs > 1) {
            return false;
        } else {
            if (length1 > length2) {
                // 保持 first 不比 second 长
                return oneEditAway(second, first);
            } else if (length1 == length2) {
                for (int i = 0; i < length1; i++) {
                    if (first.charAt(i) != second.charAt(i)) {
                        return first.substring(i + 1).equals(second.substring(i + 1));
                    }
                }
            } else if (length1 < length2) {
                for (int i = 0; i < length1; i++) {
                    if (first.charAt(i) != second.charAt(i)) {
                        return first.substring(i).equals(second.substring(i + 1));
                    }
                }
            }
        }
        return true;
    }
}
