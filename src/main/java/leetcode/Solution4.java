package leetcode;

/**
 * 4. 寻找两个正序数组的中位数
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))
 *
 * @author fzhang
 * @date 2020-08-11
 */
public class Solution4 {
    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * @param nums1 升序数组1
     * @param nums2 升序数组2
     * @return 两个正序数组的中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;

        int left = (length + 1) / 2;
        int right = (length + 2) / 2;

        int kthLeft = findKth(nums1, 0, length1 - 1, nums2, 0, length2 - 1, left);
        int kthRight = findKth(nums1, 0, length1 - 1, nums2, 0, length2 - 1, right);

        return (kthLeft + kthRight) / 2.0;
    }

    /**
     * 找到两个数组所有数字中第 k 大的元素
     *
     * @param nums1  正序数组1
     * @param start1 左端索引
     * @param end1   右端索引
     * @param nums2  正序数组2
     * @param start2 左端索引
     * @param end2   右端索引
     * @param k      第 k 大
     * @return 第 k 大的元素值
     */
    private int findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return findKth(nums2, start2, end2, nums1, start1, end1, k);
        }

        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return findKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return findKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
