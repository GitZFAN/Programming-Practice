package jobsCodeExam2020.meituan;

import java.util.Arrays;

/**
 * [4,5,1,6,2,7,3,8]
 * 求数组中第K大的值
 * 第2大：7
 *
 * @author 13585
 * @date 2020-11-07
 */
public class Interview1 {
    /**
     * 通过全局排序的方法，复杂度为 O(nlogn) 较高
     * <p>
     * 比较好的方法：基于快速排序或者基于堆排序，因为不需要对全局都进行排序
     *
     * @param args 命令行参数
     * @see leetcode.Solution215 215. 数组中的第K个最大元素
     */
    public static void main(String[] args) {
        int[] ints = {4, 5, 1, 6, 2, 7, 3, 8};

        Arrays.sort(ints);

        int k = 2;

        System.out.println("第 " + k + " 个最大的元素：" + ints[ints.length - k]);
    }
}
