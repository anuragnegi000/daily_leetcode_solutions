class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Base case: If the tree is empty, there's nothing to invert.
        if (root == null) {
            return null;
        }

        // Recursively invert the left and right subtrees.
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // Swap the left and right subtrees of the current node.
        root.left = right;
        root.right = left;

        return root;
    }
}
