class Solution {
    public int countVowelPermutation(int n) {
        final int MOD = 1000000007;
        
        // Create a 2D array to store counts.
        // dp[i][j] represents the count of strings of length i ending with vowel j.
        long[][] dp = new long[n][5];
        
        // Initialize the count for strings of length 1.
        for (int j = 0; j < 5; j++) {
            dp[0][j] = 1;
        }
        
        // Populate the dp array.
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % MOD; // 'a' can follow 'e', 'i', or 'u'.
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD; // 'e' can follow 'a' or 'i'.
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % MOD; // 'i' can follow 'e' or 'o'.
            dp[i][3] = dp[i - 1][2]; // 'o' can only follow 'i'.
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % MOD; // 'u' can follow 'i' or 'o'.
        }
        
        // Calculate the total count by summing up counts for all vowels at position n - 1.
        long count = 0;
        for (int j = 0; j < 5; j++) {
            count = (count + dp[n - 1][j]) % MOD;
        }
        
        return (int) count;
    }
}
