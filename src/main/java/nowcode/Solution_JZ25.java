package nowcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution_JZ25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        List<RandomListNode> pList = new LinkedList<>();
        List<RandomListNode> nList = new LinkedList<>();

        Queue<RandomListNode> queue = new LinkedList<>();
        queue.offer(pHead);

        while (!queue.isEmpty()) {
            RandomListNode node = queue.poll();
            pList.add(node);
            RandomListNode randomListNode = new RandomListNode(node.label);
            nList.add(randomListNode);
            if (node.next != null && !pList.contains(node.next)) {
                queue.offer(node.next);
            }
            if (node.random != null && !pList.contains(node.random)) {
                queue.offer(node.random);
            }
        }

        for (int i = 0; i < nList.size(); i++) {
            RandomListNode nNode = nList.get(i);
            RandomListNode pNode = pList.get(i);
            if (pNode.next != null) {
                int index = pList.indexOf(pNode.next);
                nNode.next = nList.get(index);
            }
            if (pNode.random != null) {
                int index = pList.indexOf(pNode.random);
                nNode.random = nList.get(index);
            }
        }

        return nList.get(0);
    }
}
