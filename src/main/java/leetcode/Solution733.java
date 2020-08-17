package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 733. 图像渲染
 *
 * @author fzhang
 * @date 2020-08-17
 */
public class Solution733 {
    public static void main(String[] args) {
        int[][] ints = {{0, 0, 0},
                {0, 0, 0}};
        Solution733 solution733 = new Solution733();
        int[][] floodFill = solution733.floodFill(ints, 0, 0, 2);
        System.out.println("floodFill = " + Arrays.deepToString(floodFill));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (0 <= sr && sr < image.length) {
            if (0 <= sc && sc < image[sr].length) {
                // sr 和 sc 满足要求
                int oldColor = image[sr][sc];
                if (oldColor == newColor) {
                    // 若颜色没有变化，则不需要进行操作
                    return image;
                }

                Deque<int[]> queue = new LinkedList<>();
                int[] index = {sr, sc};
                image[index[0]][index[1]] = newColor;
                queue.offer(index);

                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    // 判断上下左右方向元素下标是否满足数组基本要求
                    if (poll[0] - 1 >= 0) {
                        if (image[poll[0] - 1][poll[1]] == oldColor) {
                            image[poll[0] - 1][poll[1]] = newColor;
                            queue.offer(new int[]{poll[0] - 1, poll[1]});
                        }
                    }
                    if (poll[0] + 1 < image.length) {
                        if (image[poll[0] + 1][poll[1]] == oldColor) {
                            image[poll[0] + 1][poll[1]] = newColor;
                            queue.offer(new int[]{poll[0] + 1, poll[1]});
                        }
                    }
                    if (poll[1] - 1 >= 0) {
                        if (image[poll[0]][poll[1] - 1] == oldColor) {
                            image[poll[0]][poll[1] - 1] = newColor;
                            queue.offer(new int[]{poll[0], poll[1] - 1});
                        }
                    }
                    if (poll[1] + 1 < image[poll[0]].length) {
                        if (image[poll[0]][poll[1] + 1] == oldColor) {
                            image[poll[0]][poll[1] + 1] = newColor;
                            queue.offer(new int[]{poll[0], poll[1] + 1});
                        }
                    }
                }
            }
        }
        return image;
    }
}
