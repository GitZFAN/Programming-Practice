package nowcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_JZ17 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;
        }

        if (root1 == null) {
            return false;
        }

        if (isSubStructure(root1, root2)) {
            return true;
        } else {
            if (root1.left != null) {
                if (HasSubtree(root1.left, root2)) {
                    return true;
                }
            }
            if (root1.right != null) {
                if (HasSubtree(root1.right, root2)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isSubStructure(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSubStructure(root1.left, root2.left) && isSubStructure(root1.right, root2.right);

    }

    /**
     * 这种方式不行，因为需要按值进行比对
     */
    public boolean HasSubtree1(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == root2) {
                return true;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }
}
