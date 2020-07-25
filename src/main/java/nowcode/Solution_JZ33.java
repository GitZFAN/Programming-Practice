package nowcode;

import java.util.LinkedList;

public class Solution_JZ33 {

    public static void main(String[] args) {
        Solution_JZ33 solution_jz33 = new Solution_JZ33();
        System.out.println(solution_jz33.GetUglyNumber_Solution(10));
    }

    public int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int newNum;
        while (integers.size() < index) {
            newNum = Math.min(2 * integers.get(index2), Math.min(3 * integers.get(index3), 5 * integers.get(index5)));
            integers.add(newNum);
            if (newNum == 2 * integers.get(index2)) {
                index2 += 1;
            }
            if (newNum == 3 * integers.get(index3)) {
                index3 += 1;
            }
            if (newNum == 5 * integers.get(index5)) {
                index5 += 1;
            }
        }
        return integers.getLast();
    }
}
