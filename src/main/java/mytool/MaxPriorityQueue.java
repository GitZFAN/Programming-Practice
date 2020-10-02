package mytool;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最大优先队列
 * <p>
 * 注意和{@link PriorityQueue}进行对比
 *
 * @author fzhang
 * @date 2020-09-30
 */
public class MaxPriorityQueue {
    int capacity = 16;
    int[] nums;
    int heapSize = -1;

    public static void main(String[] args) {
        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue(6);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        // 3, 2, 1, 5, 6, 4
        maxPriorityQueue.insert(3);
        maxPriorityQueue.insert(2);
        maxPriorityQueue.insert(1);
        maxPriorityQueue.insert(5);
        System.out.println("maxPriorityQueue.pollMaxNum() = " + maxPriorityQueue.pollMaxNum());
        maxPriorityQueue.insert(6);
        System.out.println("maxPriorityQueue.maximumsNum() = " + maxPriorityQueue.peekMaxNum());
        maxPriorityQueue.insert(4);

    }

    public MaxPriorityQueue() {
        nums = new int[capacity];
    }

    public MaxPriorityQueue(int capacity) {
        this.capacity = capacity;
        nums = new int[capacity];
    }

    public void insert(int x) {
        if (heapSize == capacity - 1) {
            System.out.println("队列已满，出现故障");
            return;
        }

        heapSize += 1;
        nums[heapSize] = Integer.MIN_VALUE;
        increasePriority(heapSize, x);
    }

    public void increasePriority(int index, int priority) {
        if (index > heapSize) {
            System.out.println("索引越界，出现故障");
            return;
        }
        nums[index] = priority;

        int parent = parent(index);
        while (index > 0 && nums[parent] < nums[index]) {
            maxHeapify(heapSize, parent);
            index = parent;
            parent = parent(index);
        }
    }

    public int peekMaxNum() {
        if (heapSize < 0) {
            System.out.println("队列为空，出现故障");
            return -1;
        }
        return nums[0];
    }

    public int pollMaxNum() {
        if (heapSize < 0) {
            System.out.println("队列为空，出现故障");
            return -1;
        }
        int result = nums[0];
        nums[0] = nums[heapSize];
        heapSize -= 1;
        maxHeapify(heapSize, 0);
        return result;
    }

    private void maxHeapify(int heapSize, int index) {
        int largest = index;
        int l = left(index);
        int r = right(index);
        if (l <= heapSize) {
            // 和左节点进行比较
            if (nums[l] > nums[largest]) {
                largest = l;
            }
        }
        if (r <= heapSize) {
            // 和右节点进行比较
            if (nums[r] > nums[largest]) {
                largest = r;
            }
        }

        if (largest != index) {
            // 如果发生交换，递归维护堆的性质
            swap(index, largest);
            maxHeapify(heapSize, largest);
        }
    }

    public void swap(int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 父节点索引
     * <p>
     * 注意：因为(-1 / 2) = 0，节点0返回0，但是节点0没有父节点
     *
     * @param index 当前节点索引
     * @return index父节点索引
     */
    public int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * 左子节点索引
     *
     * @param index 当前节点索引
     * @return index左子节点索引
     */
    public int left(int index) {
        return 2 * index + 1;
    }

    /**
     * 右子节点索引
     *
     * @param index 当前节点索引
     * @return index右子节点索引
     */
    public int right(int index) {
        return 2 * (index + 1);
    }
}
