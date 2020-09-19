package mytool;

import java.util.*;

/**
 * 对 Map 类型所有进行 排序 操作相关测试
 *
 * @author fzhang
 * @date 2020-09-07
 */
public class MapSortTest {
    public static void main(String[] args) {
        MapSortTest mapSortTest = new MapSortTest();
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 4);
        hashMap.put("e", 1);
        hashMap.put("c", 3);
        hashMap.put("ab", 2);
        hashMap.put("d", 3);
        System.out.println("hashMap.entrySet() = " + hashMap.entrySet());
        List<Map.Entry<String, Integer>> hashMapByKey = mapSortTest.sortMapByKey(hashMap);
        System.out.println("hashMapByKey = " + hashMapByKey);
        List<Map.Entry<String, Integer>> hashMapByValue = mapSortTest.sortMapByValue(hashMap);
        System.out.println("hashMapByValue = " + hashMapByValue);

        TreeMap<String, Integer> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 按 key 进行 降序 排列
                return o2.compareTo(o1);
            }
        });
        treeMap.put("a", 4);
        treeMap.put("e", 1);
        treeMap.put("c", 3);
        treeMap.put("ab", 2);
        treeMap.put("d", 3);
        System.out.println("treeMap.entrySet() = " + treeMap.entrySet());
        List<Map.Entry<String, Integer>> treeMapByValue = mapSortTest.sortMapByValue(treeMap);
        System.out.println("treeMapByValue = " + treeMapByValue);
    }

    /**
     * 对 Map<String, Integer> 类型中的所有 entry 按 value 进行 降序 排列
     *
     * @param map Map<String, Integer> 类型
     * @return 排序之后的所有 entry 构成的 list
     */
    private List<Map.Entry<String, Integer>> sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entryArrayList = new ArrayList<>(map.entrySet());
        entryArrayList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 按 value 进行 降序 排列
                // 注意：不要直接使用 o2.getValue() - o2.getValue()，存在溢出问题
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return entryArrayList;
    }

    /**
     * 对 Map<String, Integer> 类型中的所有 entry 按 key 进行 降序 排列
     *
     * @param map Map<String, Integer> 类型
     * @return 排序之后的所有 entry 构成的 list
     */
    private List<Map.Entry<String, Integer>> sortMapByKey(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entryArrayList = new ArrayList<>(map.entrySet());
        entryArrayList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 按 key 进行 降序 排列
                return o2.getKey().compareTo(o1.getKey());
            }
        });
        return entryArrayList;
    }

}
