package nowcode;

import java.util.HashMap;

public class Solution_JZ28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int length = array.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>(length);
        for (int integer : array) {
            if (hashMap.containsKey(integer)) {
                Integer fre = hashMap.get(integer);
                fre += 1;
                if (fre > length / 2) {
                    return integer;
                }
                hashMap.put(integer, fre);
            } else {
                hashMap.put(integer, 1);
            }
        }
        return 0;
    }
}
