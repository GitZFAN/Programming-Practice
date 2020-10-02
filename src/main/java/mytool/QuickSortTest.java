package mytool;

import java.util.Arrays;

/**
 * 快速排序 相关操作实现
 *
 * @author fzhang
 * @date 2020-09-30
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        QuickSortTest quickSort = new QuickSortTest();
        quickSort.sort(ints);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序：分治思想
     * <p>
     * 对 nums[left, right] 进行快速排序
     *
     * @param nums  无序数组
     * @param left  起始索引
     * @param right 终止索引
     */
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = randomPartition(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
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
     */
    public int randomPartition(int[] nums, int left, int right) {
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
     */
    public int partition(int[] nums, int left, int right) {
        int value = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= value) {
                i += 1;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
