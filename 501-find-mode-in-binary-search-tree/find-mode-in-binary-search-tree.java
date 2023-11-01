import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

class Solution {
    private Map<Integer, Integer> frequencyMap;

    private void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);

            // Update the frequency map
            int val = root.val;
            frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);

            inOrderTraversal(root.right);
        }
    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        frequencyMap = new HashMap<>();
        inOrderTraversal(root);

        int maxFreq = 0;
        List<Integer> modes = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int val = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {
                modes.clear();
                modes.add(val);
                maxFreq = freq;
            } else if (freq == maxFreq) {
                modes.add(val);
            }
        }

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }
}
