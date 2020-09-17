package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * <p>
 * 难点：最重要的洞察是我们只需要一种一致的方式来访问中值元素，这是不容易观察到的。
 * 不需要对整个输入进行排序。
 *
 * @author 13585
 * @date 2020-09-16
 */
public class Solution295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
    }
}

/**
 * 两个优先队列（堆）
 */
class MedianFinder {
    /**
     * 小倒三角形
     * 大根堆，用来存放较小的那一半的元素
     */
    PriorityQueue<Integer> smallMaxHeap;
    /**
     * 梯形
     * 小根堆，用来存放较大的那一半的元素
     */
    PriorityQueue<Integer> largeMinHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        smallMaxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 降序排列
                // 注意：经验证，这里使用 o2 - o1 存在溢出问题，因此不推荐。
                // 在遇到特殊数据超过 Integer.MAX_VALUE 后变成了负数，导致数据比较大小出错。。
                return o2.compareTo(o1);
            }
        });
        largeMinHeap = new PriorityQueue<>();
    }

    /**
     * 不仅要维护 largeMinHeap 和 smallMaxHeap 的元素个数之差不超过 1，
     * 还要维护 largeMinHeap 堆的堆顶元素要大于等于 smallMaxHeap 堆的堆顶元素
     *
     * @param num 新流进的元素
     */
    public void addNum(int num) {
        if (smallMaxHeap.size() >= largeMinHeap.size()) {
            smallMaxHeap.offer(num);
            largeMinHeap.offer(smallMaxHeap.poll());
        } else {
            largeMinHeap.offer(num);
            smallMaxHeap.offer(largeMinHeap.poll());
        }
    }

    /**
     * 取流进的所有元素的中位数，只需考虑两个堆的堆顶元素
     *
     * @return 中位数
     */
    public double findMedian() {
        if (smallMaxHeap.size() < largeMinHeap.size()) {
            return largeMinHeap.peek();
        } else {
            // 注意：这里需要加上 (double) 强制转化，否则也存在溢出问题
            return ((double) smallMaxHeap.peek() + (double) largeMinHeap.peek()) / 2.0;
        }

    }
}

/**
 * 二分查找 + 插入排序
 * <p>
 * 复杂度分析
 * <p>
 * 时间复杂度：O(n) + O(log n) ≈ O(n).
 * 二分搜索需要花费 O(log n) 时间才能找到正确的插入位置。
 * 插入可能需要花费 O(n) 的时间，因为必须在容器中移动元素为新元素腾出空间。
 * 空间复杂度：O(n) 线性空间，用于在容器中保存输入。
 */
class MedianFinder1 {
    LinkedList<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MedianFinder1() {
        list = new LinkedList<>();
    }

    /**
     * 二分查找，找到需要插入的位置（考虑到插入的复杂度，这里查找右边界）
     *
     * @param num 被插入的元素
     */
    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
        } else {
            int left = 0;
            int right = list.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (num == list.get(mid)) {
                    // 注意
                    left = mid + 1;
                } else if (num > list.get(mid)) {
                    left = mid + 1;
                } else if (num < list.get(mid)) {
                    right = mid;
                }
            }

            if (left == 0) {
                // list 中所有元素都大于num
                list.add(0, num);
            } else if (list.get(left - 1) != num) {
                // list 中所有的元素都小于num
                list.add(left, num);
            } else {
                list.add(left, num);
            }
        }
    }

    public double findMedian() {
        int size = list.size();
        if (size % 2 == 0) {
            // 偶数
            return (list.get((size - 1) / 2) + list.get((size - 1) / 2 + 1)) / 2.0;
        } else {
            // 奇数
            return list.get((size - 1) / 2);
        }
    }
}