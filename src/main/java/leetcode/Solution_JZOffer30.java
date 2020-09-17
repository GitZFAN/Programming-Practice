package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 30. 包含min函数的栈
 *
 * @author 13585
 * @date 2020-09-15
 */
public class Solution_JZOffer30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-2);
        minStack.push(-3);
        System.out.print("minStack.top() = " + minStack.top() + ", ");
        System.out.println("minStack.min() = " + minStack.min());
        minStack.pop();
        System.out.print("minStack.top() = " + minStack.top() + ", ");
        System.out.println("minStack.min() = " + minStack.min());
        minStack.pop();
        System.out.print("minStack.top() = " + minStack.top() + ", ");
        System.out.println("minStack.min() = " + minStack.min());
    }
}

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
class MinStack {

    Deque<Integer> stack;
    /**
     * 辅助栈：非严格递增，单调栈（Deque实现）
     */
    Deque<Integer> supStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
        supStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!supStack.isEmpty()) {
            if (x <= supStack.peek()) {
                supStack.push(x);
            }
        } else {
            supStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (pop.equals(supStack.peek())) {
                supStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return supStack.peek();
    }
}
