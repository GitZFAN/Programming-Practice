package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 *
 * @author 13585
 * @date 2020-09-15
 */
public class Solution_JZOffer59_2 {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        System.out.println("maxQueue.max_value() = " + maxQueue.max_value());
        maxQueue.push_back(2);
        System.out.println("maxQueue.max_value() = " + maxQueue.max_value());
        System.out.println("maxQueue.pop_front() = " + maxQueue.pop_front());
        System.out.println("maxQueue.max_value() = " + maxQueue.max_value());
    }
}

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
class MaxQueue {
    Queue<Integer> queue;
    /**
     * 辅助双向队列：非严格递减，单调队列（Deque实现）
     */
    Deque<Integer> supDeque;

    public MaxQueue() {
        queue = new LinkedList<>();
        supDeque = new LinkedList<>();
    }

    /**
     * @return 当前队列里的最大值，若队列为空，则返回 -1
     */
    public int max_value() {
        if (supDeque.isEmpty()) {
            return -1;
        } else {
            return supDeque.peekFirst();
        }
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!supDeque.isEmpty()) {
            if (supDeque.peekLast() < value) {
                supDeque.pollLast();
            } else {
                break;
            }
        }
        supDeque.offerLast(value);
    }

    /**
     * @return 弹出的队首元素，若队列为空，则返回 -1
     */
    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            Integer poll = queue.poll();
            if (poll.equals(supDeque.peekFirst())) {
                supDeque.pollFirst();
            }
            return poll;
        }
    }
}