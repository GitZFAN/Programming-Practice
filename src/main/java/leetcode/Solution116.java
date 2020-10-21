package leetcode;

import java.util.LinkedList;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * @author fzhang
 * @date 2020-10-21
 */
public class Solution116 {
    /**
     * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * <p>
     * 初始状态下，所有 next 指针都被设置为 NULL。
     * <p>
     * 方法一：层次遍历
     *
     * @param root 给定二叉树的根节点
     * @return 修改后的二叉树
     */
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 当前 queue 中的 size 表示当前层中所有的 Node
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                Node poll = queue.poll();
                if (poll.left != null) {
                    poll.left.next = poll.right;
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    poll.right.next = poll.next.left;
                    queue.offer(poll.right);
                }
            }

            // 处理最后一个节点
            Node poll = queue.poll();
            if (poll.left != null) {
                poll.left.next = poll.right;
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                poll.right.next = null;
                queue.offer(poll.right);
            }
        }

        return root;
    }

    /**
     * 方法二：使用已建立的 next 指针
     *
     * @param root 给定二叉树的根节点
     * @return 修改后的二叉树
     */
    public Node connect(Node root) {
        Node head = root;

        while (head != null) {
            Node levelNode = head;
            while (levelNode != null) {
                if (levelNode.left != null) {
                    levelNode.left.next = levelNode.right;
                }
                if (levelNode.right != null) {
                    if (levelNode.next == null) {
                        levelNode.right.next = null;
                    } else {
                        levelNode.right.next = levelNode.next.left;
                    }
                }
                levelNode = levelNode.next;
            }
            head = head.left;
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}