package nowcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution_JZ64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> maxValues = new ArrayList<>();

        if (size == 0 || num == null || num.length == 0) {
            return maxValues;
        }

        if (size > num.length) {
            return maxValues;
        }

        LinkedList<Integer> dequeue = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            // 向单调队列中添加元素
            while (true) {
                if (dequeue.isEmpty()) {
                    dequeue.addLast(i);
                    break;
                }
                Integer last = dequeue.getLast();
                if (num[last] < num[i]) {
                    dequeue.removeLast();
                } else {
                    dequeue.addLast(i);
                    break;
                }
            }

            // 判断单调队列中队首元素是否过期，删除过期元素
            while (true) {
                Integer first = dequeue.getFirst();
                if (first < i-size+1) {
                    dequeue.removeFirst();
                } else {
                    break;
                }
            }

            // 输出结果
            if (i >= size-1) {
                Integer first = dequeue.getFirst();
                maxValues.add(num[first]);
            }
        }

        /*
        int valueIndex = maxValueIndex(num, 0, size);
        maxValues.add(num[valueIndex]);
        for (int i = 1; i+size <= num.length; i++) {
            if (valueIndex != i-1) {
                if (num[valueIndex] >= num[i+size-1]) {
                    maxValues.add(num[valueIndex]);
                    continue;
                }
            }
            valueIndex = maxValueIndex(num, i, size);
            maxValues.add(num[valueIndex]);
        }*/

        return maxValues;
    }

    private int maxValueIndex(int[] num, int begin, int size) {
        int maxV = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = begin; i < begin+size; i++) {
            if (num[i] > maxV) {
                maxV = num[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
