package jobsCodeExam2020.shangjiaosuo;

import java.util.*;

/**
 * 采摘果实
 *
 * @author 13585
 * @date 2020-10-24
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        int T = scanner.nextInt();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < S; i++) {
            int num = scanner.nextInt();
            for (int j = 0; j < num; j++) {
                int day = scanner.nextInt();
                if (!hashMap.containsKey(day)) {
                    hashMap.put(day, 1);
                } else {
                    Integer number = hashMap.get(day);
                    hashMap.put(day, number + 1);
                }
            }
        }

        ArrayList<Map.Entry<Integer, Integer>> arrayList = new ArrayList<>(hashMap.entrySet());
        arrayList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue().compareTo(o2.getValue()) != 0) {
                    return o2.getValue().compareTo(o1.getValue());
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });


        Map.Entry<Integer, Integer> entry = arrayList.get(0);
        if (entry.getValue() >= T) {
            System.out.println(entry.getKey());
        } else {
            System.out.println(0);
        }

    }
}
