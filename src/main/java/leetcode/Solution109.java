package leetcode;

import java.util.LinkedList;

/**
 * 109. 有序链表转换二叉搜索树
 *
 * @author fzhang
 * @date 2020-08-18
 */
public class Solution109 {
    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getLength(head);

        return constructBST(0, length - 1);
    }

    /**
     * 方法二：分治 + 中序遍历优化
     *
     * @param from 中序遍历结果起始下标
     * @param end  中序遍历结果终止下标
     * @return BST
     */
    private TreeNode constructBST(int from, int end) {
        if (from > end) {
            return null;
        }

        int mid = (from + end) / 2;
        TreeNode leftTree = constructBST(from, mid - 1);

        // 这里反映了中序遍历的特性，一颗BST树的中序遍历结果一定是升序的
        TreeNode treeNode = new TreeNode(globalHead.val);
        globalHead = globalHead.next;

        TreeNode rightTree = constructBST(mid + 1, end);
        treeNode.left = leftTree;
        treeNode.right = rightTree;
        return treeNode;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length += 1;
            head = head.next;
        }
        return length;
    }

    public TreeNode sortedListToBST1(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return buildBST(list, 0, list.size() - 1);
    }

    /**
     * 方法一：分治
     *
     * @param list 升序排列的数字列表
     * @param from 起始下标
     * @param end  终止下标
     * @return BST
     */
    private TreeNode buildBST(LinkedList<Integer> list, int from, int end) {
        if (end - from > 1) {
            // 至少有3个元素
            int mid = (from + end) / 2;
            Integer mVal = list.get(mid);
            TreeNode treeNode = new TreeNode(mVal);
            treeNode.left = buildBST(list, from, mid - 1);
            treeNode.right = buildBST(list, mid + 1, end);
            return treeNode;
        } else if (end - from == 1) {
            Integer fVal = list.get(from);
            TreeNode fNode = new TreeNode(fVal);
            Integer eVal = list.get(end);
            TreeNode eNode = new TreeNode(eVal);
            eNode.left = fNode;
            return eNode;
        }
        if (end == from) {
            Integer integer = list.get(from);
            return new TreeNode(integer);
        }
        return null;
    }
}
