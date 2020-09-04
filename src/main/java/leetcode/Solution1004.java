package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 1004. 最大连续1的个数 III
 *
 * @author fzhang
 * @date 2020-09-04
 */
public class Solution1004 {
    public static void main(String[] args) {
        Solution1004 solution1004 = new Solution1004();
        String str = "abbcccddddeeeee";
        List<CharAndCount> list = solution1004.decompositionString(str);
        System.out.println("list = " + list);

        int[] ints = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int longestOnes = solution1004.longestOnes(ints, 3);
        System.out.println("longestOnes = " + longestOnes);
    }

    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0;
        int count = 0;
        int result = Integer.MIN_VALUE;

        while (right < A.length) {
            if (A[right] == 0) {
                count += 1;
            }
            if (count > K) {
                // 0 的个数超过K，将 left 移动到第一个0后面位置
                for (int i = left; i <= right; i++) {
                    if (A[i] == 0) {
                        left = i + 1;
                        count -= 1;
                        break;
                    }
                }
            }
            result = Math.max(result, right - left + 1);
            right += 1;
        }

        return result;
    }

    private List<CharAndCount> decompositionString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        List<CharAndCount> list = new LinkedList<>();
        if (str.length() == 1) {
            CharAndCount charAndCount = new CharAndCount(str.charAt(0), 1);
            list.add(charAndCount);
        } else {
            char memChar = str.charAt(0);
            int count = 1;

            for (int i = 1; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == memChar) {
                    count += 1;
                } else {
                    CharAndCount charAndCount = new CharAndCount(memChar, count);
                    list.add(charAndCount);
                    memChar = c;
                    count = 1;
                }
            }
            CharAndCount charAndCount = new CharAndCount(memChar, count);
            list.add(charAndCount);
        }

        return list;
    }
}

class CharAndCount {
    char aChar;
    int count;

    public CharAndCount(char aChar, int count) {
        this.aChar = aChar;
        this.count = count;
    }

    @Override
    public String toString() {
        return "CharAndCount{" +
                "aChar=" + aChar +
                ", count=" + count +
                '}';
    }
}
