package nowcode.bilibili;

import leetcode.Solution1004;

import java.util.ArrayList;

/**
 * 求字符串中所有片段长度的平均值
 *
 * @author 13585
 * @date 2020-09-04
 * @see Solution1004#decompositionString(java.lang.String)
 */
public class Solution3 {
    public int GetFragment(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }

        char c = str.charAt(0);
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == c) {
                count += 1;
            } else {
                list.add(count);
                c = charAt;
                count = 1;
            }
        }
        list.add(count);

        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }

        return sum / list.size();
    }
}
