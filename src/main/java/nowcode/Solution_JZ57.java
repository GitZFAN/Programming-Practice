package nowcode;

public class Solution_JZ57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            return midTraverseFirst(pNode.right);
        } else {
            return getNextNode(pNode.next, pNode);
        }

    }

    private TreeLinkNode getNextNode(TreeLinkNode node, TreeLinkNode preNode) {
        if (node == null) {
            return null;
        }
        if (node.left == preNode) {
            return node;
        } else if (node.right == preNode) {
            return getNextNode(node.next, node);
        }
        return null;
    }

    private TreeLinkNode midTraverseFirst(TreeLinkNode pNode) {
        if (pNode.left != null) {
            return midTraverseFirst(pNode.left);
        }
        return pNode;
    }
}
