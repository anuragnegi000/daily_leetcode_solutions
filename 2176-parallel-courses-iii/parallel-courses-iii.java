class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] graph = new ArrayList[n];
        int[] inDegree = new int[n];
        int[] dp = new int[n];

        // Initialize the graph and in-degrees
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] rel : relations) {
            int u = rel[0] - 1; // 0-based indexing
            int v = rel[1] - 1; // 0-based indexing
            graph[u].add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Initialize the queue with nodes having in-degree of 0
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                dp[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph[u]) {
                inDegree[v]--;
                dp[v] = Math.max(dp[v], dp[u] + time[v]);
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            maxTime = Math.max(maxTime, dp[i]);
        }

        return maxTime;
    }
}
