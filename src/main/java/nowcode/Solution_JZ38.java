package nowcode;

public class Solution_JZ38 {
    public int TreeDepth(TreeNode root) {
        if (root != null) {
            int leftDepth = TreeDepth(root.left);
            int rightDepth = TreeDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return 0;
    }
}
