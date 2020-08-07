package leetcode;

/**
 * 100. 相同的树
 *
 * @author fzhang
 * @date 2020-08-07
 */
public class Solution100 {
    /**
     * 给定两个二叉树，检验它们是否相同
     *
     * @param p p树的根结点
     * @param q q树的根结点
     * @return 如果相同返回true，否则返回false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            boolean sameLeft = isSameTree(p.left, q.left);
            boolean sameRight = isSameTree(p.right, q.right);

            return sameLeft && sameRight;
        } else {
            return p == null && q == null;
        }
    }
}
