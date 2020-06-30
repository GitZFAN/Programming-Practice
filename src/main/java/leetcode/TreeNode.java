package leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public void preOrderTraversal() {
        System.out.print(val + " ");
        if (left != null) {
            left.preOrderTraversal();
        }
        if (right != null) {
            right.preOrderTraversal();
        }
    }

    public void inOrderTraversal() {
        if (left != null) {
            left.inOrderTraversal();
        }
        System.out.print(val + " ");
        if (right != null) {
            right.inOrderTraversal();
        }
    }
}