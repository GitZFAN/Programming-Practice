package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 454. 四数相加 II
 *
 * @author fzhang
 * @date 2020-11-27
 */
public class Solution454 {
    /**
     * 给定四个包含整数的数组列表 A , B , C , D ,
     * 计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
     * <p>
     * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
     * 所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
     * <p>
     * <p>
     * 题解：这里采用的策略是：存两个数组算两个数组，利用 HashMap 的查找特性（和存储）。
     * <p>
     * 时间复杂度：O(n^2)。我们使用了两次二重循环，时间复杂度均为 O(n^2)。
     * 在循环中对哈希映射进行的修改以及查询操作的期望时间复杂度均为 O(1)，因此总时间复杂度为 O(n^2)。
     * <p>
     * 空间复杂度：O(n^2)，即为哈希映射需要使用的空间。在最坏的情况下，A[i]+B[j] 的值均不相同，
     * 因此值的个数为 n^2，也就需要 O(n^2) 的空间。
     * <p>
     *
     * @param A 整数数组
     * @param B 整数数组
     * @param C 整数数组
     * @param D 整数数组
     * @return 结果为0的组合数
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i : A) {
            for (int j : B) {
                int sum = i + j;
                if (hashMap.containsKey(sum)) {
                    hashMap.put(sum, hashMap.get(sum) + 1);
                } else {
                    hashMap.put(sum, 1);
                }
            }
        }

        int count = 0;

        for (int i : C) {
            for (int j : D) {
                int target = i + j;
                target *= -1;
                if (hashMap.containsKey(target)) {
                    count += hashMap.get(target);
                }
            }
        }


        return count;
    }

    /**
     * 超时，原因：并没有利用到 HashMap 高效查找特性
     */
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : A) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, 1);
            } else {
                hashMap.put(i, hashMap.get(i) + 1);
            }
        }

        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            for (int i : B) {
                int nkey = key + i;
                if (!hashMap1.containsKey(nkey)) {
                    hashMap1.put(nkey, value);
                } else {
                    hashMap1.put(nkey, hashMap1.get(nkey) + value);
                }
            }
        }
        hashMap = hashMap1;

        hashMap1 = new HashMap<>();
        entries = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            for (int i : C) {
                int nkey = key + i;
                if (!hashMap1.containsKey(nkey)) {
                    hashMap1.put(nkey, value);
                } else {
                    hashMap1.put(nkey, hashMap1.get(nkey) + value);
                }
            }
        }
        hashMap = hashMap1;

        hashMap1 = new HashMap<>();
        entries = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            for (int i : D) {
                int nkey = key + i;
                if (!hashMap1.containsKey(nkey)) {
                    hashMap1.put(nkey, value);
                } else {
                    hashMap1.put(nkey, hashMap1.get(nkey) + value);
                }
            }
        }
        hashMap = hashMap1;

        if (!hashMap.containsKey(0)) {
            return 0;
        }

        return hashMap.get(0);
    }
}
