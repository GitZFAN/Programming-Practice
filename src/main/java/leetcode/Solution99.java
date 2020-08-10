package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 99. 恢复二叉搜索树
 *
 * @author fzhang
 * @date 2020-08-10
 */
public class Solution99 {

    /**
     * 中序遍历方式得到数组，找出结果中被交换的两个数字，然后继续遍历树，找到对应节点进行修改
     *
     * @param root BST的根节点
     */
    public void recoverTree(TreeNode root) {
        LinkedList<Integer> integers = inOrderList(root);

        ArrayList<Integer> list = new ArrayList<>(2);
        for (int i = 0; i < integers.size() - 1; i++) {
            if (integers.get(i) > integers.get(i + 1)) {
                list.add(i);
            }
        }

        if (list.size() == 1) {
            Integer integer = list.get(0);
            recover(root, integers.get(integer), integers.get(integer + 1));
        } else {
            Integer x = list.get(0);
            Integer y = list.get(1);
            recover(root, integers.get(x), integers.get(y + 1));
        }
    }

    private void recover(TreeNode root, Integer x, Integer y) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            root.val = y;
        } else if (root.val == y) {
            root.val = x;
        }

        recover(root.left, x, y);
        recover(root.right, x, y);

    }

    private LinkedList<Integer> inOrderList(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<Integer> result = new LinkedList<>();
        if (root.left != null) {
            LinkedList<Integer> integers = inOrderList(root.left);
            result.addAll(integers);
        }
        result.add(root.val);
        if (root.right != null) {
            LinkedList<Integer> integers = inOrderList(root.right);
            result.addAll(integers);
        }
        return result;
    }

    /**
     * 这种方式只能解决特殊case
     *
     * @param root BST的根节点
     */
    public void recoverTree_fail(TreeNode root) {
        TreeNode left = findLeft(root.left, root.val);
        TreeNode right = findRight(root.right, root.val);
        if (left != null) {
            if (right != null) {
                // 交换 left 与 right
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
            } else {
                // 交换 left 与 root
                int temp = left.val;
                left.val = root.val;
                root.val = temp;
            }
        } else {
            if (right != null) {
                // 交换 right 与 root
                int temp = right.val;
                right.val = root.val;
                root.val = temp;
            }
        }
    }

    private TreeNode findRight(TreeNode right, int val) {
        if (right == null) {
            return null;
        } else {
            if (right.val < val) {
                return right;
            } else {
                TreeNode left1 = findRight(right.left, val);
                if (left1 != null) {
                    return left1;
                }
                return findRight(right.right, val);
            }
        }
    }

    private TreeNode findLeft(TreeNode left, int val) {
        if (left == null) {
            return null;
        }
        if (left.val > val) {
            return left;
        } else {
            TreeNode left1 = findLeft(left.left, val);
            if (left1 != null) {
                return left1;
            }
            return findLeft(left.right, val);
        }
    }

}
