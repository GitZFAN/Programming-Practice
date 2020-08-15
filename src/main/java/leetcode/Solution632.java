package leetcode;

import java.util.*;

/**
 * 632. 最小区间
 *
 * @author fzhang
 * @date 02/08/2020
 */
public class Solution632 {
    // DONE: 8/2/20 此题暂时不会，解决方法参考题解。方法一：堆；方法二：哈希表 + 滑动窗口。


    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        int[] ints1 = {4, 10, 15, 24, 26};
        for (int i : ints1) {
            integers.add(i);
        }
        nums.add(integers);

        ints1 = new int[]{0, 9, 12, 20};
        integers = new ArrayList<>();
        for (int i : ints1) {
            integers.add(i);
        }
        nums.add(integers);

        ints1 = new int[]{5, 18, 22, 30};
        integers = new ArrayList<>();
        for (int i : ints1) {
            integers.add(i);
        }
        nums.add(integers);

        for (List<Integer> num : nums) {
            for (Integer integer : num) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        Solution632 solution632 = new Solution632();
        int[] ints = solution632.smallestRange(nums);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    /**
     * 方法一：堆
     * <p/>该问题可以转化为，从 k 个列表中各取一个数，使得这 k 个数中的最大值与最小值的差最小。
     *
     * @param nums k 个升序排列的整数列表
     * @return 最小区间
     *
     * <p>定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        int minRange = rangeRight - rangeLeft;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] next = new int[size];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer index1, Integer index2) {
                return nums.get(index1).get(next[index1]) - nums.get(index2).get(next[index2]);
            }
        });
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            int minIndex = priorityQueue.poll();
            int curRange = max - nums.get(minIndex).get(next[minIndex]);
            if (curRange < minRange) {
                minRange = curRange;
                rangeLeft = nums.get(minIndex).get(next[minIndex]);
                rangeRight = max;
            }
            next[minIndex]++;
            if (next[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            priorityQueue.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }
        return new int[]{rangeLeft, rangeRight};
    }
}
