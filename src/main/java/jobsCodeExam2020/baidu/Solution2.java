package jobsCodeExam2020.baidu;

import java.util.*;

/**
 * @author 13585
 * @date 2020-09-14
 */
public class Solution2 {
    public static void main(String[] args) {
        // 测试样例
        // 6 6
        //C 3 6
        //C 4 1
        //Q 1 6
        //C 1 6
        //Q 1 6
        //Q 2 5
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(i);
            hashMap.put(i, list);
        }

        String[] strings = new String[m];
        for (int i = 0; i < m; i++) {
            strings[i] = scanner.nextLine();
        }

        for (String s : strings) {
            String[] splits = s.split(" ");
            if ("C".equals(splits[0])) {
                // C
                Integer key1 = Integer.valueOf(splits[1]);
                Integer key2 = Integer.valueOf(splits[2]);
                moveList(hashMap, key1, key2);
            } else {
                // Q
                Integer key1 = Integer.valueOf(splits[1]);
                Integer key2 = Integer.valueOf(splits[2]);
                System.out.println(queryKey(hashMap, key1, key2));
            }
        }
    }

    private static int queryKey(HashMap<Integer, List<Integer>> hashMap, Integer key1, Integer key2) {
        List<Integer> list1 = hashMap.get(key1);
        List<Integer> list2 = hashMap.get(key2);
        if (list1 != null) {
            if (list1.contains(key2)) {
                return list1.indexOf(key2) - 1;
            } else {
                return -1;
            }
        }
        if (list2 != null) {
            if (list2.contains(key1)) {
                return list2.indexOf(key1) - 1;
            } else {
                return -1;
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : hashMap.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list != null) {
                int index1 = list.indexOf(key1);
                int index2 = list.indexOf(key2);
                if (index1 != -1 && index2 != -1) {
                    return Math.abs(index1 - index2) - 1;
                }
            }
        }
        return -1;
    }

    private static void moveList(HashMap<Integer, List<Integer>> hashMap, Integer key1, Integer key2) {
        List<Integer> list1 = hashMap.get(key1);
        List<Integer> list2 = hashMap.get(key2);
        hashMap.put(key1, null);

        list2.addAll(list1);

        hashMap.put(key2, list2);
    }
}
