package jobsCodeExam2020.redbook;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小自然数
 *
 * @author 13585
 * @date 2020-09-12
 */
public class Solution1 {

    /**请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int findMin(int[] tree) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : tree) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        if (min > 1) {
            return 1;
        } else {
            for (int i = 1; i <= max; i++) {
                if (Arrays.binarySearch(tree, i) == -1) {
                    return i;
                }
            }
        }

        return 0;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _tree_size = 0;
        _tree_size = Integer.parseInt(in.nextLine().trim());
        int[] _tree = new int[_tree_size];
        int _tree_item;
        for(int _tree_i = 0; _tree_i < _tree_size; _tree_i++) {
            _tree_item = Integer.parseInt(in.nextLine().trim());
            _tree[_tree_i] = _tree_item;
        }

        res = findMin(_tree);
        System.out.println(String.valueOf(res));

    }
}


