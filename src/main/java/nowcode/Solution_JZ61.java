package nowcode;


public class Solution_JZ61 {
    public static void main(String[] args) {
        /**
         * tree:
         * 1
         * 2 3
         * # 4 5 #
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        Solution_JZ61 solution_jz61 = new Solution_JZ61();
        String serialize = solution_jz61.Serialize(null);
        System.out.println(serialize);

        TreeNode deserializeNode = solution_jz61.Deserialize(serialize);
        String serialize1 = solution_jz61.Serialize(deserializeNode);
        System.out.println(serialize1);
    }

    int index = 0;

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#,";
        }

        return root.val + "," + Serialize(root.left) + Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }

        String[] splits = str.split(",");

        return deserializeArray(splits);
    }

    private TreeNode deserializeArray(String[] splits) {
        String value = splits[index];
        index += 1;

        if ("#".equals(value)) {
            return null;
        }

        int parseInt = Integer.parseInt(value);
        TreeNode treeNode = new TreeNode(parseInt);

        treeNode.left = deserializeArray(splits);
        treeNode.right = deserializeArray(splits);
        return treeNode;
    }
}
