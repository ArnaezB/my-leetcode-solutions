package medium;

public class problem1026 {
    public static void main(String[] args) {
        System.out.println(maxAncestorDiff(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null)))));
    }

    public static int maxAncestorDiff(TreeNode root) {
        return aux(root, root.val, root.val);
    }

    private static int aux(TreeNode current, int max, int min) {
        if (current == null) { return max-min;}
        max = Math.max(max, current.val);
        min = Math.min(min, current.val);

        return Math.max(aux(current.left, max, min), aux(current.right, max, min));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}