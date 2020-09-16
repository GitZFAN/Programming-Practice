package leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author 13585
 * @date 2020-09-16
 */
public class Solution34 {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
     * 找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *
     * @param nums   一个按照升序排列的整数数组
     * @param target 目标值
     * @return 给定目标值在数组中的开始位置和结束位置，如果数组中不存在目标值，返回 [-1, -1]。
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ints = new int[2];
        ints[0] = leftBound(nums, target);
        ints[1] = rightBound(nums, target);

        return ints;
    }

    private int rightBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;
        // 搜索区间：[left, right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 注意
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (left == 0) {
            // nums 中所有元素都大于 target
            return -1;
        }

        if (nums[left - 1] != target) {
            // nums 中所有元素都小于 target
            return -1;
        } else {
            return left - 1;
        }
    }

    private int leftBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;
        // 搜索区间：[left, right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 注意
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (left == nums.length) {
            // nums 中所有元素都小于 target
            return -1;
        }

        if (nums[left] != target) {
            // nums 中所有元素都大于 target
            return -1;
        } else {
            return left;
        }
    }
}
