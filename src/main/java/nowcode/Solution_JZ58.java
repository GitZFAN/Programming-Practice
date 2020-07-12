package nowcode;

public class Solution_JZ58 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        TreeNode rRoot = new TreeNode(pRoot.val);
        mirrorTree(pRoot, rRoot);

        return isEqualTree(pRoot, rRoot);

    }

    private boolean isEqualTree(TreeNode pRoot, TreeNode rRoot) {
        if (pRoot == null || rRoot == null) {
            return pRoot == null && rRoot == null;
        } else if (pRoot.val == rRoot.val) {
            return isEqualTree(pRoot.left, rRoot.left) && isEqualTree(pRoot.right, rRoot.right);
        }
        return false;
    }

    private void mirrorTree(TreeNode pRoot, TreeNode rRoot) {
        if (pRoot.left != null) {
            TreeNode treeNode = new TreeNode(pRoot.left.val);
            mirrorTree(pRoot.left, treeNode);
            rRoot.right = treeNode;
        }
        if (pRoot.right != null) {
            TreeNode treeNode = new TreeNode(pRoot.right.val);
            mirrorTree(pRoot.right, treeNode);
            rRoot.left = treeNode;
        }
    }
}
