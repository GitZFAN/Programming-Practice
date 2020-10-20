package leetcode;

import java.util.Comparator;
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
        String str = "addddbbccceeeee";
        List<CharAndCount> list = solution1004.decompositionString(str);
        System.out.println("list = " + list);
        list.sort(new Comparator<CharAndCount>() {
            @Override
            public int compare(CharAndCount o1, CharAndCount o2) {
                // 根据 char 出现的频率进行 倒序 排列
                return o2.count - o1.count;
            }
        });
        System.out.println("list = " + list);

        int[] ints = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int longestOnes = solution1004.longestOnes(ints, 3);
        System.out.println("longestOnes = " + longestOnes);
    }

    /**
     * 滑动窗口的常规解法
     * <p>
     * 与 {@link Solution424#characterReplacement(String, int)} 一样的套路，不过更为简单一点。
     *
     * @param arr 由若干 0 和 1 组成的数组
     * @param K   最多可以将 K 个值从 0 变成 1
     * @return 仅包含 1 的最长（连续）子数组的长度
     */
    public int longestOnes(int[] arr, int K) {
        int left = 0;
        // 表示 滑动窗口中 1 的最大数量
        int maxCount1 = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 1) {
                maxCount1 += 1;
            }
            // 窗口默认一直向右扩展
            if ((right - left + 1) > (maxCount1 + K)) {
                // 但是 当窗口大小 超过 当前容纳最大1的数量+K 时候（即窗口中容纳的0的数量超过K），
                // 窗口需要缩小，也即向右滑动，而不是扩展
                if (arr[left] == 1) {
                    maxCount1 -= 1;
                }
                left += 1;
            }
        }

        return arr.length - left;
    }

    /**
     * 滑动窗口的简单方法
     * <p>
     * 直接用count统计窗口内的0的个数
     *
     * @param arr 由若干 0 和 1 组成的数组
     * @param K   最多可以将 K 个值从 0 变成 1
     * @return 仅包含 1 的最长（连续）子数组的长度
     */
    public int longestOnes1(int[] arr, int K) {
        int left = 0, right = 0;
        // count用来统计窗口中0的个数
        int count = 0;
        int result = 0;

        while (right < arr.length) {
            if (arr[right] == 0) {
                count += 1;
            }
            if (count > K) {
                // 当窗口内 0 的个数超过K，将 left 移动到第一个0后面位置
                for (int i = left; i <= right; i++) {
                    if (arr[i] == 0) {
                        left = i + 1;
                        count -= 1;
                        break;
                    }
                }
            }
            // 窗口内0的个数小于等于k时，也就是可以该窗口内的0都可以替换，根据该窗口长度来确定是否更新result
            result = Math.max(result, right - left + 1);
            right += 1;
        }

        return result;
    }

    public List<CharAndCount> decompositionString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        // DONE: 2020/9/8 思考：这里为什么需要构造 CharAndCount 类来记录 片段数据
        //  而不是直接使用HashMap结构？
        //  因为：输入str 中 可能存在 char 相同的 片段，HashMap无法保存key相同value不同的片段
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
