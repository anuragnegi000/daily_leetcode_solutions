import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // Add the current node's value to the result list
        result.add(node.val);

        // Recursively traverse the left and right subtrees
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }
}
