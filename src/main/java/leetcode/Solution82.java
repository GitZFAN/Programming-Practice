package leetcode;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @author fzhang
 * @date 2021-03-25
 */
public class Solution82 {
    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，
     * 只保留原始链表中 没有重复出现 的数字。
     * <p>
     * 返回同样按升序排列的结果链表。
     *
     * @param head 按升序排列的链表头节点
     * @return 返回去除重复元素的结果链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode(0, head);

        ListNode pre = preHead;
        ListNode node = head;
        while (node != null) {
            boolean flag = false;
            ListNode next = node.next;
            while (next != null && node.val == next.val) {
                // node 为重复节点
                next = next.next;
                flag = true;
            }

            if (flag) {
                node = next;
                pre.next = node;
            } else {
                node = next;
                pre = pre.next;
            }
        }

        return preHead.next;
    }
}
