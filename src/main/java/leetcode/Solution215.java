package leetcode;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author fzhang
 * @date 2020-09-30
 */
public class Solution215 {
    public static void main(String[] args) {
        int[] ints = {3, 2, 1, 5, 6, 4};
        Solution215 solution215 = new Solution215();
        int kthLargest = solution215.findKthLargest(ints, 2);
        System.out.println("kthLargest = " + kthLargest);
    }

    /**
     * 在未排序的数组中找到第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 快速排序方法
     *
     * @param nums 未排序的数组
     * @param k    数组排序后的第 k 个最大的元素
     * @return 数组排序后的第 k 个最大的元素
     */
    public int findKthLargest(int[] nums, int k) {
        int kthIndex = nums.length - k;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int p = randomizedPartition(nums, left, right);
            if (p < kthIndex) {
                left = p + 1;
            } else if (p > kthIndex) {
                right = p - 1;
            } else {
                // p == kthIndex
                return nums[p];
            }
        }

        return 0;
    }

    /**
     * 快速排序核心方法<b>优化</b>：数组的<b>随机</b>划分
     * <p>
     * 实现了对 子数组 nums[left, right] 的 原址重排
     *
     * @param nums  原数组
     * @param left  起始索引
     * @param right 终止索引
     * @return 选取的 主元(一般：nums[right]) 的排序后索引
     * @see mytool.QuickSortTest#randomizedPartition(int[], int, int)
     */
    private int randomizedPartition(int[] nums, int left, int right) {
        int length = right - left + 1;
        // 范围：[0.0, 1.0)
        double rdm = Math.random();
        int rdmIndex = ((int) (rdm * length)) + left;
        swap(nums, rdmIndex, right);
        return partition(nums, left, right);
    }

    /**
     * 快速排序核心方法：数组的划分
     * <p>
     * 实现了对 子数组 nums[left, right] 的 原址重排
     *
     * @param nums  原数组
     * @param left  起始索引
     * @param right 终止索引
     * @return 选取的 主元(一般：nums[right]) 的排序后索引
     * @see mytool.QuickSortTest#partition(int[], int, int)
     */
    private int partition(int[] nums, int left, int right) {
        int value = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < value) {
                swap(nums, i + 1, j);
                i += 1;
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    /**
     * 堆排序方法
     *
     * @param nums 未排序的数组
     * @param k    数组排序后的第 k 个最大的元素
     * @return 数组排序后的第 k 个最大的元素
     * @see mytool.MaxHeapSortTest 堆排序算法
     * @see mytool.MaxPriorityQueue 最大优先队列
     */
    public int findKthLargest1(int[] nums, int k) {
        // 1. 建堆
        buildHeap(nums);

        int lastIndex = nums.length - 1;

        // 2. 挨个移除元素
        for (int i = 0; i < k - 1; i++) {
            nums[0] = nums[lastIndex];
            lastIndex -= 1;
            maxHeapify(nums, lastIndex, 0);
        }
        return nums[0];
    }

    private void buildHeap(int[] nums) {
        int lastIndex = nums.length - 1;
        int parent = parent(lastIndex);

        for (int i = parent; i >= 0; i--) {
            maxHeapify(nums, lastIndex, i);
        }
    }

    private void maxHeapify(int[] nums, int lastIndex, int index) {
        int largestIndex = index;
        int left = leftNodeIndex(index);
        int right = rightNodeIndex(index);

        if (left <= lastIndex && nums[largestIndex] < nums[left]) {
            largestIndex = left;
        }

        if (right <= lastIndex && nums[largestIndex] < nums[right]) {
            largestIndex = right;
        }

        if (largestIndex != index) {
            swap(nums, largestIndex, index);
            maxHeapify(nums, lastIndex, largestIndex);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private int rightNodeIndex(int index) {
        return 2 * (index + 1);
    }

    private int leftNodeIndex(int index) {
        return 2 * index + 1;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }
}
