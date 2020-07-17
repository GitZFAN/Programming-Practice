package nowcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Solution_JZ40 {
    /**
     * 通过遍历的方式记录 array 中出现的所有的数字以及每个数字出现的次数
     * 注：通过 HashMap 进行存储
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int x :
                array) {
            if (hashMap.containsKey(x)) {
                hashMap.put(x, 2);
            } else {
                hashMap.put(x, 1);
            }
        }
        Set<Entry<Integer, Integer>> entries = hashMap.entrySet();
        int flag = 0;

        // 使用foreach高级迭代方式遍历
        for (Entry<Integer, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (value == 1) {
                Integer key = entry.getKey();
                if (flag == 0) {
                    num1[0] = key;
                } else {
                    num2[0] = key;
                    return;
                }
                flag += 1;
            }
        }

        /*// 使用迭代器方式进行遍历
        Iterator<Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Entry<Integer, Integer> next = iterator.next();
            Integer value = next.getValue();
            if (value == 1) {
                Integer key = next.getKey();
                if (flag == 0) {
                    num1[0] = key;
                } else {
                    num2[0] = key;
                    return;
                }
                flag += 1;
            }
        }*/
    }

    /**
     * 通过位运算实现
     * 基本原理：位运算中异或(^)的性质：两个相同数字异或=0，一个数和0异或还是它本身。
     */
    public void FindNumsAppearOnce1(int[] array, int[] num1, int[] num2) {
        int length = array.length;
        if (length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for (int i = 0; i < length; ++i) {
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for (int i = 0; i < length; ++i) {
            if (isBit1(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    private int findFirst1(int bitResult) {
        int index = 0;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }
}
