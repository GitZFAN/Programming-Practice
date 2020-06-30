package nowcode;

public class Solution_JZ62 {

    public static int count = 0;
    public static int target;

    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(6);
        pRoot.left = new TreeNode(5);
        pRoot.right = new TreeNode(7);

        Solution_JZ62 solution_jz62 = new Solution_JZ62();
        TreeNode treeNode = solution_jz62.KthNode(pRoot, 2);
        System.out.println(treeNode.val);
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        target = k;
        return midTraverse(pRoot);
    }

    private TreeNode midTraverse(TreeNode pRoot) {
        if (pRoot.left != null) {
            TreeNode treeNode = midTraverse(pRoot.left);
            if (count == target) {
                return treeNode;
            }
        }

        count += 1;
        if (count == target) {
            return pRoot;
        }

        if (pRoot.right != null) {
            TreeNode treeNode = midTraverse(pRoot.right);
            if (count == target) {
                return treeNode;
            }
        }
        return null;
    }

}
