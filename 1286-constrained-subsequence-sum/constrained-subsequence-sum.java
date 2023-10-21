public class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxSum = nums[0];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (!deque.isEmpty()) {
                dp[i] += Math.max(0, dp[deque.peek()]);
            }
            maxSum = Math.max(maxSum, dp[i]);

            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
        }

        return maxSum;
    }
}
