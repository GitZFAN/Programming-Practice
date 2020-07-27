package nowcode;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution_JZ24 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        if (root.val > target) {
            return result;
        }

        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.val);
                result.add(list);
                return result;
            } else {
                return result;
            }
        }

        ArrayList<ArrayList<Integer>> leftPath = FindPath(root.left, target - root.val);
        if (leftPath.size() != 0) {
            result.addAll(leftPath);
        }

        ArrayList<ArrayList<Integer>> rightPath = FindPath(root.right, target - root.val);
        if (rightPath.size() != 0) {
            result.addAll(rightPath);
        }

        if (result.size() != 0) {
            result.sort(new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return o1.get(0) - o2.get(0);
                }
            });
            for (ArrayList<Integer> list : result) {
                list.add(0, root.val);
            }
            return result;
        } else {
            return result;
        }
    }
}
