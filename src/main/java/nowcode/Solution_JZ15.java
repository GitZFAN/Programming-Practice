package nowcode;

public class Solution_JZ15 {
    /**
     * 反转链表
     */
    public ListNode ReverseList(ListNode head) {
        ListNode helpNode = new ListNode(0);
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = helpNode.next;
            helpNode.next = temp;
        }
        return helpNode.next;
    }
}
