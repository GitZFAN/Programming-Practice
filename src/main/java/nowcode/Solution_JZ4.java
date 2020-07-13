package nowcode;

public class Solution_JZ4 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        return constructTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode constructTree(int[] pre, int pFrom, int pEnd, int[] in, int iFrom, int iEnd) {
        if (pFrom > pEnd) {
            return null;
        }
        if (pFrom == pEnd) {
            return new TreeNode(pre[pFrom]);
        }
        TreeNode node = new TreeNode(pre[pFrom]);

        int target = iFrom;
        for (; target <= iEnd; target++) {
            if (pre[pFrom] == in[target]) {
                break;
            }
        }

        int leftNum = target - iFrom;

        node.left = constructTree(pre, pFrom + 1, pFrom + leftNum, in, iFrom, target - 1);
        node.right = constructTree(pre, pFrom + leftNum + 1, pEnd, in, target + 1, iEnd);

        return node;
    }

}
