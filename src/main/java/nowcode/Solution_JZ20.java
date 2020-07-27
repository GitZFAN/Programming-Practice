package nowcode;

import java.util.LinkedList;

public class Solution_JZ20 {

    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> sort = new LinkedList<>();

    public static void main(String[] args) {
        Solution_JZ20 solution_jz20 = new Solution_JZ20();
        solution_jz20.push(3);
        System.out.println("solution_jz20.min() = " + solution_jz20.min());
        solution_jz20.push(4);
        System.out.println("solution_jz20.min() = " + solution_jz20.min());
        solution_jz20.push(2);
        System.out.println("solution_jz20.min() = " + solution_jz20.min());

    }

    public void push(int node) {
        stack.push(node);
        int i = 0;
        for (; i < sort.size(); i++) {
            Integer integer = sort.get(i);
            if (node < integer) {
                sort.add(i, node);
                break;
            }
        }
        if (i == sort.size()) {
            sort.add(node);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        for (int i = 0; i < sort.size(); i++) {
            Integer integer = sort.get(i);
            if (pop.equals(integer)) {
                sort.remove(i);
                break;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return sort.getFirst();
    }
}
