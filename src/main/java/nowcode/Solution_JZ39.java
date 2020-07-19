package nowcode;

public class Solution_JZ39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            int leftDeepth = getDeepth(root.left);
            int rightDeepth = getDeepth(root.right);
            if (Math.abs(leftDeepth - rightDeepth) <= 1) {
                return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
            } else {
                return false;
            }

        }
    }

    private int getDeepth(TreeNode root) {
        if (root == null) {
            return -1;
        } else {
            int leftDeepth = getDeepth(root.left);
            int rightDeepth = getDeepth(root.right);
            int max = Math.max(leftDeepth, rightDeepth);
            return 1 + max;
        }
    }
}
