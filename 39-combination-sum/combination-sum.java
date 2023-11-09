import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remaining, int start) {
        if (remaining < 0) {
            return; // If remaining is negative, it means the current combination exceeds the target.
        } else if (remaining == 0) {
            result.add(new ArrayList<>(currentList)); // Valid combination found, add it to the result.
        } else {
            for (int i = start; i < candidates.length; i++) {
                currentList.add(candidates[i]);
                // Recursively explore the next combination with the updated remaining value and starting index.
                backtrack(result, currentList, candidates, remaining - candidates[i], i);
                currentList.remove(currentList.size() - 1); // Backtrack by removing the last added element.
            }
        }
    }
}
