package leetcode;

/**
 * 337. 打家劫舍 III
 *
 * @author fzhang
 * @date 2020-08-05
 */
public class Solution337 {
    public int rob(TreeNode root) {
        int maxValue1 = maxValue(root, true);
        int maxValue2 = maxValue(root, false);
        return Math.max(maxValue1, maxValue2);
    }

    private int maxValue(TreeNode root, boolean isRootRob) {
        int value = 0;
        if (root != null) {
            if (isRootRob) {
                // 根节点一定被访问
                value += root.val;
                value += maxValue(root.left, false);
                value += maxValue(root.right, false);
            } else {
                // 根结点不允许访问
                value += Math.max(maxValue(root.left, false), maxValue(root.left, true));
                value += Math.max(maxValue(root.right, false), maxValue(root.right, true));
            }
        }
        return value;
    }
}
