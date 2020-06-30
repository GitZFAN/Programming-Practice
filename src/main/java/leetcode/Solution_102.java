package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution_102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();

        Queue<TreeNode> thisLevel = new LinkedList<>();
        if (root != null) {
            thisLevel.add(root);
        }

        while (!thisLevel.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> nextLevel = new LinkedList<>();
            while (!thisLevel.isEmpty()) {
                TreeNode node = thisLevel.poll();
                level.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            thisLevel = nextLevel;
            tree.add(level);
        }

        return tree;
    }
}