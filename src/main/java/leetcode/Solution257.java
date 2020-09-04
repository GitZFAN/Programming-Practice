package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * @author fzhang
 * @date 2020-09-04
 */
public class Solution257 {
    List<String> result = new LinkedList<>();
    List<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        treeNode.left = node2;
        treeNode.right = node3;
        node2.right = node5;

        Solution257 solution257 = new Solution257();
        List<String> strings = solution257.binaryTreePaths(treeNode);

        System.out.println("strings = " + strings);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        travelTree(root);
        return result;
    }

    private void travelTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
            result.add(printPath());
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            travelTree(root.left);
        }
        if (root.right != null) {
            travelTree(root.right);
        }
        path.remove(path.size() - 1);
    }

    private String printPath() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : path) {
            stringBuilder.append(integer).append("->");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }
}
