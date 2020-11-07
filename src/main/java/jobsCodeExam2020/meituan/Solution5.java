package jobsCodeExam2020.meituan;

import java.util.*;

/**
 * 按事件重要程度、优先级进行排序
 *
 * @author 13585
 * @date 2020-09-13
 */
public class Solution5 {
    public static void main(String[] args) {
        // 测试样例：
        // 2
        //9 3
        //1 4
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        HashMap<Integer, Thing> hashMap = new HashMap<>();

        for (int i = 1; i <= length; i++) {
            int anInt0 = scanner.nextInt();
            int anInt1 = scanner.nextInt();
            Thing thing = new Thing(anInt0, anInt1);
            hashMap.put(i, thing);
        }

        ArrayList<Map.Entry<Integer, Thing>> entries = sortMapByValue(hashMap);

        for (int i = 0; i < entries.size() - 1; i++) {
            Map.Entry<Integer, Thing> integerThingEntry = entries.get(i);
            System.out.print(integerThingEntry.getKey() + " ");
        }
        System.out.println(entries.get(entries.size() - 1).getKey());

    }

    private static ArrayList<Map.Entry<Integer, Thing>> sortMapByValue(HashMap<Integer, Thing> hashMap) {
        ArrayList<Map.Entry<Integer, Thing>> entryArrayList = new ArrayList<>(hashMap.entrySet());
        entryArrayList.sort(new Comparator<Map.Entry<Integer, Thing>>() {
            @Override
            public int compare(Map.Entry<Integer, Thing> o1, Map.Entry<Integer, Thing> o2) {
                Thing thing1 = o1.getValue();
                Thing thing2 = o2.getValue();
                if (thing1.importance != thing2.importance) {
                    return thing2.importance - thing1.importance;
                } else if (thing1.priority != thing2.priority) {
                    return thing2.priority - thing1.priority;
                }
                return 0;
            }
        });
        return entryArrayList;
    }
}

class Thing {
    int priority;
    int importance;

    public Thing(int priority, int importance) {
        this.priority = priority;
        this.importance = importance;
    }
}