package nowcode;

import java.util.ArrayList;

public class Solution_JZ3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> results = new ArrayList<>();

        ListNode reverseHeadNode = new ListNode(0);

        while (listNode != null) {
            ListNode tempNode = listNode;
            listNode = listNode.next;
            tempNode.next = reverseHeadNode.next;
            reverseHeadNode.next = tempNode;
        }

        ListNode next = reverseHeadNode.next;

        while (next != null) {
            results.add(next.val);
            next = next.next;
        }

        return results;
    }
}
