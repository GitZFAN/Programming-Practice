package leetcode;

/**
 * 114. 二叉树展开为链表
 *
 * @author fzhang
 * @date 02/08/2020
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        // 先序遍历
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }

    }
}
