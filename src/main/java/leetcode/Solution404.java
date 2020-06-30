package leetcode;

public class Solution404 {
    public static void main(String[] args) {

    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftNode(root.left) + sumOfRightNode(root.right);
    }

    private int sumOfLeftNode(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.val;
        } else {
            return sumOfLeftNode(root.left) + sumOfRightNode(root.right);
        }
    }

    private int sumOfRightNode(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 0;
        } else {
            return sumOfLeftNode(root.left) + sumOfRightNode(root.right);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
