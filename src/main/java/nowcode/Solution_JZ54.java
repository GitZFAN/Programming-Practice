package nowcode;

import java.util.HashSet;
import java.util.LinkedList;

public class Solution_JZ54 {

    public static void main(String[] args) {
        Solution_JZ54 solution_jz54 = new Solution_JZ54();
        solution_jz54.Insert('g');
        System.out.print(solution_jz54.FirstAppearingOnce() + " ");
        solution_jz54.Insert('o');
        System.out.print(solution_jz54.FirstAppearingOnce() + " ");
        solution_jz54.Insert('o');
        System.out.print(solution_jz54.FirstAppearingOnce() + " ");
        solution_jz54.Insert('g');
        System.out.print(solution_jz54.FirstAppearingOnce() + " ");
        solution_jz54.Insert('l');
        System.out.print(solution_jz54.FirstAppearingOnce() + " ");
        solution_jz54.Insert('e');
        System.out.print(solution_jz54.FirstAppearingOnce() + " ");

    }

    HashSet<Character> allChar = new HashSet<>();
    LinkedList<Character> onceChar = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (!allChar.contains(ch)) {
            allChar.add(ch);
            onceChar.add(ch);
        } else {
            int index = onceChar.indexOf(ch);
            if (index != -1) {
                onceChar.remove(index);
            }
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (onceChar.isEmpty()) {
            return '#';
        }
        return onceChar.getFirst();
    }
}
