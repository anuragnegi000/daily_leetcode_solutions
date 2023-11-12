public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        queue.offer(source);
        visitedStops.add(source);
        int busCount = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            busCount++;

            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();

                for (int route : stopToRoutes.getOrDefault(currentStop, Collections.emptyList())) {
                    if (visitedRoutes.contains(route)) {
                        continue;
                    }

                    visitedRoutes.add(route);

                    for (int nextStop : routes[route]) {
                        if (visitedStops.contains(nextStop)) {
                            continue;
                        }

                        if (nextStop == target) {
                            return busCount;
                        }

                        visitedStops.add(nextStop);
                        queue.offer(nextStop);
                    }
                }
            }
        }

        return -1; // No valid route found
    }
}