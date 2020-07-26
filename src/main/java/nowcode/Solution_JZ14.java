package nowcode;

public class Solution_JZ14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        int total = 0;
        ListNode cur = head;
        while (cur != null) {
            total += 1;
            cur = cur.next;
        }
        if (total - k + 1 < 1) {
            return null;
        }

        cur = head;
        int index = 1;
        while (index < total - k + 1) {
            cur = cur.next;
            index += 1;
        }
        return cur;
    }
}
