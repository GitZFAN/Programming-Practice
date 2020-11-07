package jobsCodeExam2020.sougou;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 13585
 * @date 2020-09-25
 */
public class Solution3 {

    public static final int MOD = 100000007;
    HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) {
        // 输入样例：10,14,
        // [[0,1],[0,2],[0,3],[1,4],[3,4],[2,6],[4,5],
        // [5,6],[6,7],[7,8],[6,9],[9,10],[8,-1],[10,-1]]
        // 输出：10，55
        Interval[] ints = new Interval[14];
        ints[0] = new Interval(0, 1);
        ints[1] = new Interval(0, 2);
        ints[2] = new Interval(0, 3);
        ints[3] = new Interval(1, 4);
        ints[4] = new Interval(3, 4);
        ints[5] = new Interval(2, 6);
        ints[6] = new Interval(4, 5);
        ints[7] = new Interval(5, 6);
        ints[8] = new Interval(6, 7);
        ints[9] = new Interval(7, 8);
        ints[10] = new Interval(6, 9);
        ints[11] = new Interval(9, 10);
        ints[12] = new Interval(8, -1);
        ints[13] = new Interval(10, -1);
        Solution3 solution3 = new Solution3();
        Interval trim = solution3.trim(10, 14, ints);
        System.out.println("trim.start = " + trim.start);
        System.out.println("trim.end = " + trim.end);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 在Interval类中返回结果，其中start表示有效字的个数，end表示全部有效字编号的和除以100000007的余数。
     *
     * @param N    int整型 字的总数
     * @param M    int整型 连接关系的总数
     * @param conn Interval类一维数组 全部连接关系
     * @return Interval类
     */
    public Interval trim(int N, int M, Interval[] conn) {
        // write code here
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>(N + 1);
        for (int i = 0; i < M; i++) {
            if (hashMap.containsKey(conn[i].start)) {
                hashMap.get(conn[i].start).add(conn[i].end);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(conn[i].end);
                hashMap.put(conn[i].start, list);
            }
        }

        LinkedList<Integer> path = new LinkedList<>();
        dfs(hashMap, 0, path);

        int sum = 0;
        for (Integer integer : hashSet) {
            sum += integer;
            if (sum > MOD) {
                sum %= MOD;
            }
        }

        return new Interval(hashSet.size(), sum);
    }

    private void dfs(HashMap<Integer, List<Integer>> hashMap, int startIndex, LinkedList<Integer> path) {
        if (startIndex == -1) {
            for (int i = 0; i < path.size() - 1; i++) {
                hashSet.add(path.get(i));
            }
            return;
        }
        if (hashSet.contains(startIndex)) {
            hashSet.addAll(path);
            return;
        }

        List<Integer> list = hashMap.get(startIndex);

        for (Integer integer : list) {
            if (!path.contains(integer)) {
                path.offerLast(integer);
                dfs(hashMap, integer, path);
                path.pollLast();
            }
        }
    }
}
