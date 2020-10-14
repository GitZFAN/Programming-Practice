package leetcode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author fzhang
 */
public class Solution105 {
    public static void main(String[] args) {
        Solution105 solution105 = new Solution105();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = solution105.buildTree(preorder, inorder);
        treeNode.preOrderTraversal();
        System.out.println();
        treeNode.inOrderTraversal();
    }

    int[] preorderTraversal;
    int[] inorderTraversal;

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * <p>
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * @param preorder 前序遍历结果
     * @param inorder  中序遍历结果
     * @return 二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        preorderTraversal = preorder;
        inorderTraversal = inorder;

        return buildRoot(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildRoot(int preFrom, int preEnd, int inFrom, int inEnd) {
        if (preFrom == preEnd && inFrom == inEnd) {
            return new TreeNode(preorderTraversal[preFrom]);
        }
        int root = preorderTraversal[preFrom];
        TreeNode treeNode = new TreeNode(root);

        int inOrderRootIndex = 0;
        for (int i = inFrom; i <= inEnd; i++) {
            if (inorderTraversal[i] == root) {
                inOrderRootIndex = i;
            }
        }
        int leftNum = inOrderRootIndex - inFrom;
        int rightNum = inEnd - inOrderRootIndex;

        if (leftNum != 0) {
            treeNode.left = buildRoot(preFrom + 1, preFrom + leftNum,
                    inFrom, inFrom + leftNum - 1);
        }
        if (rightNum != 0) {
            treeNode.right = buildRoot(preEnd - rightNum + 1, preEnd,
                    inEnd - rightNum + 1, inEnd);
        }
        return treeNode;
    }
}
