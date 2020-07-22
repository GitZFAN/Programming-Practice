package nowcode;

import java.util.HashSet;

public class Solution_JZ36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (pHead1 != null || pHead2 != null) {
            if (pHead1 != null) {
                if (hashSet.contains(pHead1)) {
                    return pHead1;
                }
                hashSet.add(pHead1);
                pHead1 = pHead1.next;
            }
            if (pHead2 != null) {
                if (hashSet.contains(pHead2)) {
                    return pHead2;
                }
                hashSet.add(pHead2);
                pHead2 = pHead2.next;
            }
        }
        return null;
    }
}
