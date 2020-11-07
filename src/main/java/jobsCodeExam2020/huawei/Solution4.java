package jobsCodeExam2020.huawei;

import java.util.LinkedList;

/**
 * 二叉树最近共同父节点
 *
 * @author 13585
 * @date 2020-09-25
 */
public class Solution4 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(5, root);
        TreeNode node2 = new TreeNode(9, root);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(6, node1);
        TreeNode node4 = new TreeNode(4, node1);
        node1.left = node3;
        node1.right = node4;
        TreeNode node5 = new TreeNode(8, node2);
        node2.right = node5;
        TreeNode node6 = new TreeNode(2, node4);
        node4.right = node6;

        TreeNode par = getPar(root, root, node5);

        if (par != null) {
            System.out.println("par.val = " + par.val);
        } else {
            System.out.println(-1);
        }

    }

    private static TreeNode getPar(TreeNode root, TreeNode node1, TreeNode node2) {
        if (node1 == root || node2 == root) {
            return null;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        while (node1 != null) {
            linkedList.add(node1);
            node1 = node1.par;
        }

        while (node2 != null) {
            if (linkedList.contains(node2)) {
                return node2;
            }
            node2 = node2.par;
        }

        return null;
    }
}

class TreeNode {
    int val;
    TreeNode par;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode par) {
        this.val = val;
        this.par = par;
    }
}