package nowcode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution_JZ26 {
    public static void main(String[] args) {
        TreeNode leftNode = new TreeNode(1);
        TreeNode rootNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        Solution_JZ26 solution_jz26 = new Solution_JZ26();
        TreeNode convert = solution_jz26.Convert(rootNode);
        while (convert != null) {
            System.out.println(convert.val + " ");
            convert = convert.right;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        TreeNode leftTree = Convert(pRootOfTree.left);
        TreeNode rightTree = Convert(pRootOfTree.right);

        if (leftTree != null) {
            while (leftTree.right != null) {
                leftTree = leftTree.right;
            }
            leftTree.right = pRootOfTree;
            pRootOfTree.left = leftTree;
        }

        if (rightTree != null) {
            rightTree.left = pRootOfTree;
            pRootOfTree.right = rightTree;
        }

        TreeNode nHead = pRootOfTree;
        while (nHead.left != null) {
            nHead = nHead.left;
        }

        return nHead;
    }
}
