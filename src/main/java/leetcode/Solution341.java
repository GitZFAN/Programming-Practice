package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 341. 扁平化嵌套列表迭代器
 *
 * @author fzhang
 * @date 2021-03-23
 */
public class Solution341 implements Iterator<Integer> {

    Queue<Integer> queue;

    public Solution341(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        if (nestedList != null) {
            addToQueue(queue, nestedList);
        }
    }

    private void addToQueue(Queue<Integer> que, List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                que.offer(nestedInteger.getInteger());
            } else {
                addToQueue(que, nestedInteger.getList());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class NestedInteger {
    public boolean isInteger() {
        return false;
    }

    public Integer getInteger() {
        return null;
    }

    public List<NestedInteger> getList() {
        return null;
    }
}