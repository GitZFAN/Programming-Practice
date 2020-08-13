package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 133. 克隆图
 *
 * @author 13585
 * @date 2020-08-13
 */
public class Solution133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        } else if (node.neighbors.size() == 0) {
            return new Node(node.val);
        }

        Node[] originNodeArray = new Node[101];
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            originNodeArray[poll.val] = poll;
            List<Node> neighbors = poll.neighbors;
            for (Node neighbor : neighbors) {
                if (originNodeArray[neighbor.val] == null) {
                    queue.offer(neighbor);
                }
            }
        }

        Node[] copyNodeArray = new Node[101];
        for (int i = 0; i < originNodeArray.length; i++) {
            if (originNodeArray[i] != null) {
                copyNodeArray[i] = new Node(i);
            }
        }
        for (int i = 0; i < originNodeArray.length; i++) {
            if (originNodeArray[i] != null) {
                List<Node> neighbors = originNodeArray[i].neighbors;
                ArrayList<Node> arrayList = new ArrayList<>(neighbors.size());
                for (Node neighbor : neighbors) {
                    arrayList.add(copyNodeArray[neighbor.val]);
                }
                copyNodeArray[i].neighbors = arrayList;
            }
        }

        return copyNodeArray[node.val];
    }
}
