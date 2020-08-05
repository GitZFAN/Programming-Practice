package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 207. 课程表
 *
 * @author fzhang
 * @date 2020-08-04
 */
public class Solution207 {
    /**
     * 本题可约化为： 课程安排图是否是 有向无环图(DAG)。
     * 方法一：入度表（广度优先遍历）
     * 统计课程安排图中每个节点的入度，生成 入度表 indegrees。
     * 借助一个队列 queue，将所有入度为 0 的节点入队。
     *
     * @param numCourses    课程数量
     * @param prerequisites 先修课程约束，所有的边
     * @return 是否存在拓扑序
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<LinkedList<Integer>> adjacency = new ArrayList<>(numCourses);
        int[] indegrees = new int[numCourses];
        Deque<Integer> queue = new LinkedList<>();

        // 初始化 adjacency 邻接表
        for (int i = 0; i < numCourses; i++) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            adjacency.add(linkedList);
        }
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[1];
            int post = prerequisite[0];
            LinkedList<Integer> linkedList = adjacency.get(pre);
            linkedList.add(post);

            // 构造 indegrees 入度表
            indegrees[post] += 1;
        }

        // 构造 queue 入度为 0 的所有节点队列
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int remainCourses = numCourses;
        // 处理 queue 中的元素，直至 queue 中元素为空
        while (!queue.isEmpty()) {
            remainCourses -= 1;
            Integer node = queue.poll();
            LinkedList<Integer> linkedList = adjacency.get(node);
            for (Integer post : linkedList) {
                indegrees[post] -= 1;
                if (indegrees[post] == 0) {
                    queue.offer(post);
                }
            }
        }

        return remainCourses == 0;
    }
}
