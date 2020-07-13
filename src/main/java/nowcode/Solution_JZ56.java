package nowcode;

public class Solution_JZ56 {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode rHead = null;
        ListNode rTail = null;
        while (pHead != null) {
            if (pHead.next == null) {
                if (rHead == null) {
                    rHead = pHead;
                    rTail = rHead;
                } else {
                    rTail.next = pHead;
                    rTail = rTail.next;
                }
            } else {
                if (pHead.val != pHead.next.val) {
                    if (rHead == null) {
                        rHead = pHead;
                        rTail = rHead;
                    } else {
                        rTail.next = pHead;
                        rTail = rTail.next;
                    }
                } else {
                    pHead = findNextVal(pHead);
                    continue;
                }
            }
            pHead = pHead.next;
        }
        if (rTail != null) {
            rTail.next = null;
        }
        return rHead;
    }

    /**
     * 优化代码简洁度和可读性
     */
    public ListNode deleteDuplication2(ListNode pHead) {

        // 创造一个头节点，以方便碰到第一个，第二个节点就相同的情况
        ListNode head = new ListNode(0);
        // 设置 pre ，cur 指针， pre指针指向当前确定不重复的那个节点，而cur指针相当于工作指针，一直往后面搜索
        ListNode pre = head;
        ListNode cur = pHead;

        while (cur != null) {
            if (cur.next == null || cur.val != cur.next.val) {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            } else {
                cur = findNextVal(cur);
                pre.next = cur;
            }

        }
        return head.next;
    }

    private ListNode findNextVal(ListNode cur) {
        int sameVal = cur.val;
        while (cur != null) {
            if (cur.val != sameVal) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
