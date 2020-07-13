package nowcode;

import java.util.Stack;

public class Solution_JZ5 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        Solution_JZ5 solution_jz5 = new Solution_JZ5();
        solution_jz5.push(1);
        solution_jz5.push(2);
        solution_jz5.push(3);
        System.out.print(solution_jz5.pop() + " ");
        System.out.print(solution_jz5.pop() + " ");
        solution_jz5.push(4);
        System.out.print(solution_jz5.pop() + " ");
        solution_jz5.push(5);
        System.out.print(solution_jz5.pop() + " ");
        System.out.print(solution_jz5.pop() + " ");
    }

    public void push(int node) {
        if (stack1.empty()) {
            translate(stack2, stack1);
        }
        stack1.push(node);
    }

    private void translate(Stack<Integer> from, Stack<Integer> to) {
        int size = from.size();
        for (int i = 0; i < size; i++) {
            Integer integer = from.pop();
            to.push(integer);
        }
    }

    public int pop() {
        if (stack2.empty()) {
            translate(stack1, stack2);
        }
        return stack2.pop();
    }
}
