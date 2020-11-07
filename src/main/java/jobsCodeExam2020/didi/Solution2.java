package jobsCodeExam2020.didi;

import java.util.*;

/**
 * @author 13585
 * @date 2020-09-13
 */
public class Solution2 {
    public static void main(String[] args) {
        // 测试样例：
        // 4 4
        //1 2 5
        //1 3 6
        //2 4 8
        //3 4 6
        //1 4 7.9/8
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        HashMap<Integer, Integer> valueMap = new HashMap<>();
        HashMap<Integer, List<int[]>> edgeMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            // 读取一条边
            int source = scanner.nextInt();
            int target = scanner.nextInt();
            int time = scanner.nextInt();
            int[] edge = {target, time};

            if (edgeMap.containsKey(source)) {
                edgeMap.get(source).add(edge);
            } else {
                valueMap.put(source, Integer.MAX_VALUE);
                LinkedList<int[]> edgeList = new LinkedList<>();
                edgeList.add(edge);
                edgeMap.put(source, edgeList);
            }

            if (!valueMap.containsKey(target)) {
                valueMap.put(target, Integer.MAX_VALUE);
            }
        }

        int source = scanner.nextInt();
        int target = scanner.nextInt();
        String startTime = scanner.nextLine();

        System.out.println("source:" + source + "->target:" + target + "-" + startTime);

        for (int i = 1; i <= n; i++) {
            if (valueMap.containsKey(i)) {
                System.out.print("node " + i + " value:");
                System.out.print(valueMap.get(i) + "; edge:");
                List<int[]> edgeList = edgeMap.get(i);
                if (edgeList != null) {
                    for (int[] edge : edgeList) {
                        System.out.print(edge[0] + "-" + edge[1] + " ");
                    }
                }
                System.out.println();
            }
        }

        int changeNode = source;
        HashSet<Integer> visitedNodes = new HashSet<>();

        valueMap.put(source, 0);

        while (changeNode != target) {
            visitedNodes.add(changeNode);
            // 更新 路径
            List<int[]> edges = edgeMap.get(changeNode);
            if (edges != null) {
                for (int[] edge : edges) {
                    int nPath = edge[1] + valueMap.get(changeNode);
                    int minPath = Math.min(valueMap.get(edge[0]), nPath);
                    valueMap.put(edge[0], minPath);
                }
            }

            // 取最小
            changeNode = getMinNode(valueMap, visitedNodes);
        }

        Integer shortestPath = valueMap.get(target);
        String[] split = startTime.split("/");
        Integer clock = Integer.valueOf(split[1]);
        clock += shortestPath;
        System.out.println(split[0] + "/" + clock);
    }

    private static Integer getMinNode(HashMap<Integer, Integer> valueMap, HashSet<Integer> visitedNodes) {
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(valueMap.entrySet());
        entries.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> entry : entries) {
            if (!visitedNodes.contains(entry.getKey())) {
                return entry.getKey();
            }
        }
        return 0;
    }


}