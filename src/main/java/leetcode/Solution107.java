package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 *
 * @author fzhang
 * @date 2020-09-06
 */
public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Deque<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> rootLevel = new LinkedList<>();
        rootLevel.add(root);
        queue.offer(rootLevel);

        while (!queue.isEmpty()) {
            List<TreeNode> level = queue.poll();
            List<TreeNode> nextLevel = new LinkedList<>();
            LinkedList<Integer> valueList = new LinkedList<>();
            for (TreeNode treeNode : level) {
                valueList.add(treeNode.val);
                if (treeNode.left != null) {
                    nextLevel.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLevel.add(treeNode.right);
                }
            }

            if (nextLevel.size() != 0) {
                queue.offer(nextLevel);
            }
            result.push(valueList);

        }
        return result;
    }
}
