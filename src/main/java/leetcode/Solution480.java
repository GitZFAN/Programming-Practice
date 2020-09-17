package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 480. 滑动窗口中位数
 *
 * @author 13585
 * @date 2020-09-15
 * @see Solution295 数据流的中位数
 */
public class Solution480 {
    public static void main(String[] args) {
        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
        Solution480 solution480 = new Solution480();
        double[] doubles = solution480.medianSlidingWindow(ints, 3);
        System.out.println("doubles = " + Arrays.toString(doubles));
    }

    /**
     * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。
     * 窗口中有 k 个数，每次窗口向右移动 1 位。
     * 你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
     *
     * @param nums 原始数组
     * @param k    滑动窗口大小
     * @return 每次窗口移动后得到的新窗口中元素的中位数组成的数组
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new double[0];
        }

        int length = nums.length;
        // 滑动窗口变化范围：[0, k-1] -> [length-1-k+1, length-1]
        double[] result = new double[length - k + 1];

        // 两个优先权队列（堆）
        PriorityQueue<Integer> largeMinHeap = new PriorityQueue<>();
        PriorityQueue<Integer> smallMaxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 注意：这里使用 o2 - o1 存在溢出问题
                return o2.compareTo(o1);
            }
        });

        // 阶段一：滑动窗口未填满 至 滑动窗口刚填满，但起始点为0
        for (int i = 0; i < k; i++) {
            if (smallMaxHeap.size() >= largeMinHeap.size()) {
                smallMaxHeap.offer(nums[i]);
                largeMinHeap.offer(smallMaxHeap.poll());
            } else {
                largeMinHeap.offer(nums[i]);
                smallMaxHeap.offer(largeMinHeap.poll());
            }
        }

        // 添加 result[0]
        if (k % 2 == 0) {
            // 注意：这里需要加上 (double) 强制转化，否则也存在溢出问题
            result[0] = ((double)smallMaxHeap.peek() + (double)largeMinHeap.peek()) / 2.0;
        } else {
            result[0] = largeMinHeap.peek();
        }

        // 记录需要删除的数以及数量
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // 阶段二：滑动窗口填满且开始滑动
        for (int i = k; i < nums.length; i++) {
            int left = i - k + 1;
            int right = i;
            // 窗口范围：[left, right]

            // 使用变量 balance 表示两个堆是否平衡
            // 如果 balance == 0，那么两个堆平衡；（此时 三角形.size() <= 梯形.size() && size相差至多为1）

            // 如果 balance < 0，那么 梯形 中的元素较少

            // 如果 balance > 0，那么 三角形 中的元素较少
            int balance = 0;

            // 移出 nums[left-1]
            int numOut = nums[left - 1];
            if (numOut >= largeMinHeap.peek()) {
                // 从梯形中移除
                balance -= 1;
            } else {
                // 从三角形中移除
                balance += 1;
            }
            // 更新要删除的数以及数量记录
            hashMap.put(numOut, hashMap.getOrDefault(numOut, 0) + 1);

            // 加入 nums[right]
            int numIn = nums[right];
            if (!largeMinHeap.isEmpty() && numIn >= largeMinHeap.peek()) {
                balance += 1;
                largeMinHeap.offer(numIn);
            } else {
                balance -= 1;
                smallMaxHeap.offer(numIn);
            }

            // re-balance 两个优先队列
            // 此时 balance 的取值范围：{-2, -1, 0, 1, 2}
            if (balance > 0) {
                // smallMaxHeap 需要更多有效的元素
                smallMaxHeap.offer(largeMinHeap.poll());
                balance -= 1;
            } else if (balance < 0) {
                // largeMinHeap 需要更多有效的元素
                largeMinHeap.offer(smallMaxHeap.poll());
                balance += 1;
            }

            // 移除两个优先队列中堆顶但是无效的元素，保证两个优先队列堆顶元素有效
            while (hashMap.getOrDefault(largeMinHeap.peek(), 0) > 0) {
                hashMap.put(largeMinHeap.peek(),
                        hashMap.getOrDefault(largeMinHeap.peek(), 0) - 1);
                largeMinHeap.poll();
            }
            while (!smallMaxHeap.isEmpty() && hashMap.getOrDefault(smallMaxHeap.peek(), 0) > 0) {
                hashMap.put(smallMaxHeap.peek(),
                        hashMap.getOrDefault(smallMaxHeap.peek(), 0) - 1);
                smallMaxHeap.poll();
            }

            // 记录滑动窗口中位数
            if (k % 2 == 0) {
                // 注意：这里需要加上 (double) 强制转化，否则也存在溢出问题
                result[left] = ((double)smallMaxHeap.peek() + (double)largeMinHeap.peek()) / 2.0;
            } else {
                result[left] = largeMinHeap.peek();
            }
        }

        return result;
    }
}
