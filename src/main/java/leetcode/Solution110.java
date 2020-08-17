package leetcode;

/**
 * 110. 平衡二叉树
 *
 * @author fzhang
 * @date 2020-08-17
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if (Math.abs(lHeight - rHeight) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }

        return false;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int max = Math.max(lHeight, rHeight);

        return max + 1;
    }
}
