package nowcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution_JZ60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null) {
            return result;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(pRoot);

        while (list.size() != 0) {
            ArrayList<Integer> thisLevelValue = new ArrayList<>();

            LinkedList<TreeNode> nextLevelNode = new LinkedList<>();
            for (TreeNode treeNode : list) {
                thisLevelValue.add(treeNode.val);
                if (treeNode.left != null) {
                    nextLevelNode.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLevelNode.add(treeNode.right);
                }
            }
            result.add(thisLevelValue);
            list = nextLevelNode;
        }

        return result;
    }
}
