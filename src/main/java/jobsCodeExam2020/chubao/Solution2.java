package jobsCodeExam2020.chubao;

import java.util.*;

/**
 * @author 13585
 * @date 2020-09-27
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            for (int j = 1; j * 2 < split.length; j++) {
                Integer id = Integer.valueOf(split[2 * j - 1]);
                Integer value = Integer.valueOf(split[2 * j]);
                if (hashMap.containsKey(id)) {
                    value += hashMap.get(id);
                }
                hashMap.put(id, value);
            }
        }

        List<Map.Entry<Integer, Integer>> entries = sortMapByValue(hashMap);

        int len = Math.min(5, entries.size());

        for (int i = 0; i < len; i++) {
            Map.Entry<Integer, Integer> entry = entries.get(i);
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static List<Map.Entry<Integer, Integer>> sortMapByValue(HashMap<Integer, Integer> hashMap) {
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(entries);
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o2.getValue().compareTo(o1.getValue()) == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        return list;
    }
}
