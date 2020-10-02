package leetcode;

/**
 * 26. 删除排序数组中的重复项
 *
 * @author fzhang
 * @date 2020-09-30
 */
public class Solution26 {
    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 双指针法
     *
     * @param nums 排序数组
     * @return 移除重复出现的元素后数组的新长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 慢指针
        int i = 0;
        // 快指针
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i += 1;
                nums[i] = nums[j];
            }
        }

        // 结果 [0, i]
        return i + 1;
    }

    /**
     * 数组删除元素操作，从后往前修改，依然存在重复移动大量元素操作，复杂度较高
     *
     * @param nums 排序数组
     * @return 移除重复出现的元素后数组的新长度
     */
    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 从后往前修改
        int length = nums.length;
        int post = nums[length - 1];
        int index = length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != post) {
                if (i + 1 != index) {
                    // 需要移除一些元素 (i+1, index]，
                    // 即将 [index+1, length) 中所有的元素移动到 i+2 位置
                    for (int j = index + 1, k = i + 2; j < length; j++, k++) {
                        nums[k] = nums[j];
                    }
                    length -= index - (i + 1);
                }
                post = nums[i];
                index = i;
            }
        }

        // 解决最后一个元素
        if (index != 0) {
            for (int i = index + 1, j = 1; i < length; i++, j++) {
                nums[j] = nums[i];
            }
            length -= index;
        }

        return length;
    }
}
