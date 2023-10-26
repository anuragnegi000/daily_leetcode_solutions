import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1000000007;
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();

        long total = 0;
        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1L);
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int factor = arr[i] / arr[j];
                    if (dp.containsKey(factor)) {
                        dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.get(factor)) % MOD);
                    }
                }
            }
            total = (total + dp.get(arr[i])) % MOD;
        }

        return (int) total;
    }
}
