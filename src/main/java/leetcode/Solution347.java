package leetcode;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 *
 * @author fzhang
 * @date 2020-09-07
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                Integer frequency = hashMap.get(num);
                hashMap.put(num, frequency + 1);
            }
        }

        // 按照 value 大小,对 hashMap 进行排序

        // 方法一: 直接对 hashMap 进行排序
        /*
        ArrayList<Map.Entry<Integer, Integer>> entryArrayList = mapSortByValue(hashMap);
        int[] ints = new int[k];
        for (int i = 0; i < ints.length; i++) {
            Map.Entry<Integer, Integer> entry = entryArrayList.get(i);
            ints[i] = entry.getKey();
        }
        return ints;*/

        // 方法二: 手动记录 top K 的 key 和 value
        int[] topkKeys = new int[k];
        int[] topkValues = new int[k];
        Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (topkValues[k - 1] >= value) {
                // 出现频率不能排进前k
                continue;
            }

            // 出现频率能够排进前k
            int i = topkValues.length - 2;
            for (; i >= 0; i--) {
                if (topkValues[i] > value) {
                    break;
                }
            }

            // 从 i+1 处下标开始,所有元素往后顺移一位
            for (int j = topkValues.length - 1; j > i + 1; j--) {
                topkKeys[j] = topkKeys[j - 1];
                topkValues[j] = topkValues[j - 1];
            }
            // 更新前k记录
            topkKeys[i + 1] = key;
            topkValues[i + 1] = value;
        }
        return topkKeys;
    }

    private ArrayList<Map.Entry<Integer, Integer>> mapSortByValue(HashMap<Integer, Integer> hashMap) {
        Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> entryArrayList = new ArrayList<>(entrySet);
        entryArrayList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // 降序排列
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : entryArrayList) {
            System.out.println("entry = " + entry);
        }
        return entryArrayList;
    }

    private ArrayList<Map.Entry<Integer, Integer>> mapSortByKey(HashMap<Integer, Integer> hashMap) {
        Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> entryArrayList = new ArrayList<>(entrySet);
        entryArrayList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        for (Map.Entry<Integer, Integer> entry : entryArrayList) {
            System.out.println("entry = " + entry);
        }
        return entryArrayList;
    }
}
