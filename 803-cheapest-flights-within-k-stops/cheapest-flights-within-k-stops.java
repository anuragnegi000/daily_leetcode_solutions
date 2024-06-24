import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Initialize distances with a large value, use src as the starting point
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        // Step 2: Perform Bellman-Ford algorithm, but only up to k + 1 iterations (0 stops is an iteration)
        for (int i = 0; i <= k; i++) {
            // We need a temporary array to store distances for this iteration
            int[] tempDist = Arrays.copyOf(dist, n);
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], w = flight[2];
                // If the source city u is reachable, update the distance to city v
                if (dist[u] != Integer.MAX_VALUE) {
                    tempDist[v] = Math.min(tempDist[v], dist[u] + w);
                }
            }
            // Update the main distance array with the temporary distances
            dist = tempDist;
        }
        
        // Step 3: Return the distance to dst, or -1 if it's not reachable within k stops
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
