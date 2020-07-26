package nowcode;

public class Solution_JZ16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode temp = list1;
                list1 = list1.next;
                temp.next = null;
                cur.next = temp;
                cur = cur.next;
            } else {
                ListNode temp = list2;
                list2 = list2.next;
                temp.next = null;
                cur.next = temp;
                cur = cur.next;
            }
        }

        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return listNode.next;
    }
}
