package mytool;

import java.util.Arrays;

/**
 * 堆排序 相关操作实现
 *
 * @author fzhang
 * @date 2020-09-30
 */
public class MaxHeapSortTest {

    public static void main(String[] args) {
        int[] ints1 = {3, 2, 1, 5, 6, 4};
        int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        MaxHeapSortTest heapSort = new MaxHeapSortTest();
        heapSort.maxHeapSort(ints);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    /**
     * 使用 <b>最大堆结构</b>，对 nums 所有元素进行排序（升序）
     *
     * @param nums 无序数组
     */
    public void maxHeapSort(int[] nums) {
        buildMaxHeap(nums);

        int heapSize = nums.length - 1;

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, i, 0);
            heapSize -= 1;
            maxHeapify(nums, heapSize, 0);
        }
    }

    /**
     * 在 nums 中所有的元素上建立 <b>最大堆结构</b>:
     * <p>
     * 1. 完全二叉树数组形式结构
     * 2. 根节点 >= 所有子节点
     * <p>
     * TODO 这里使用的方式是 maxHeapify() ，思考：为什么不使用 插入 的方法建堆？
     * （即：反复调用 {@link MaxPriorityQueue#insert(int)}）
     * 猜想：这里的时间复杂度是O(n)，而插入方法最坏情况下的复杂度是O(nlogn)
     *
     * @param nums 无序数组
     */
    public void buildMaxHeap(int[] nums) {
        // 表示 包括在堆结构中 最后一个元素的索引
        int heapSize = nums.length - 1;

        // 最后一个非叶子节点位置
        int last = parent(heapSize);

        // 从最后一个非叶子节点开始逐层维护各个节点的堆的性质
        for (int i = last; i >= 0; i--) {
            maxHeapify(nums, heapSize, i);
        }
    }

    /**
     * 维护 堆性质
     *
     * @param nums     存储堆结构数组
     * @param heapSize 具有堆结构最后一个元素的索引
     * @param index    从 index 节点开始维护（index及其所有子节点）
     */
    public void maxHeapify(int[] nums, int heapSize, int index) {
        int largest = index;
        int l = left(index);
        int r = right(index);
        if (l <= heapSize) {
            // 和左节点进行比较
            if (nums[l] > nums[largest]) {
                largest = l;
            }
        }
        if (r <= heapSize) {
            // 和右节点进行比较
            if (nums[r] > nums[largest]) {
                largest = r;
            }
        }

        if (largest != index) {
            // 如果发生交换，递归维护堆的性质
            swap(nums, index, largest);
            maxHeapify(nums, heapSize, largest);
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 父节点索引
     * <p>
     * 注意：因为(-1 / 2) = 0，节点0返回0，但是节点0没有父节点
     *
     * @param index 当前节点索引
     * @return index父节点索引
     */
    public int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * 左子节点索引
     *
     * @param index 当前节点索引
     * @return index左子节点索引
     */
    public int left(int index) {
        return 2 * index + 1;
    }

    /**
     * 右子节点索引
     *
     * @param index 当前节点索引
     * @return index右子节点索引
     */
    public int right(int index) {
        return 2 * (index + 1);
    }
}
