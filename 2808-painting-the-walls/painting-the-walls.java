public class Solution {
    private int[][] dp = new int[501][501];
    
    public long find(int i, int topaint, int[] cost, int[] time) {
        if (topaint <= 0) return 0;
        if (dp[i][topaint] != -1) return dp[i][topaint];

        if (i == 0) {
            long cur = topaint - (time[i] + 1);
            if (cur > 0) return dp[i][topaint] = Integer.MAX_VALUE;
            else return dp[i][topaint] = cost[i];
        } else {
            
            long cur = cost[i] + find(i - 1, (topaint - (time[i] + 1)), cost, time);
            cur = Math.min(cur, find(i - 1, topaint, cost, time));
            return dp[i][topaint] = (int) cur;
        }
    }

    public int paintWalls(int[] cost, int[] time) {
        int ans = 0;
        for (int i = 0; i < 501; i++) {
            Arrays.fill(dp[i], -1);
        }
        int n = cost.length;
        return (int) find(n - 1, n, cost, time);
    }
}
