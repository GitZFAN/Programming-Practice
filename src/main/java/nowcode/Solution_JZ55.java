package nowcode;

import java.util.HashSet;

public class Solution_JZ55 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> nodes = new HashSet<>();

        while (pHead != null) {
            if (nodes.contains(pHead)) {
                return pHead;
            }
            nodes.add(pHead);
            pHead = pHead.next;
        }

        return null;
    }
}
