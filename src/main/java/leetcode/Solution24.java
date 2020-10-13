package leetcode;

/**
 * 24. 两两交换链表中的节点
 *
 * @author fzhang
 * @date 2020-10-13
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode pre = sentinel;
        while (pre.next != null) {
            ListNode swapNode1 = pre.next;
            if (swapNode1.next == null) {
                break;
            }
            ListNode swapNode2 = swapNode1.next;
            pre.next = swapNode2;
            swapNode1.next = swapNode2.next;
            swapNode2.next = swapNode1;
            pre = swapNode1;
        }
        return sentinel.next;
    }
}
