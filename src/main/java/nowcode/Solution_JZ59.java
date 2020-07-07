package nowcode;

import java.util.ArrayList;

public class Solution_JZ59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null) {
            return result;
        }

        ArrayList<TreeNode> level = new ArrayList<>();
        level.add(pRoot);

        while (level.size() != 0) {
            ArrayList<Integer> value = new ArrayList<>();
            ArrayList<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : level) {
                value.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            result.add(value);
            level = nextLevel;
        }

        ArrayList<ArrayList<Integer>> outResult = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> value = result.get(i);
            if (i % 2 != 0) {
                // reverse the value list
                ArrayList<Integer> reversValue = new ArrayList<>();
                for (int j = 0; j < value.size(); j++) {
                    Integer integer = value.get(value.size()-1 - j);
                    reversValue.add(integer);
                }
                outResult.add(reversValue);
            } else {
                outResult.add(value);
            }
        }

        return outResult;
    }
}
