class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // Calculate the number of tests a single pig can perform before dying.
        int testsPerPig = minutesToTest / minutesToDie + 1;

        // Calculate the minimum number of pigs needed to test all buckets.
        int pigs = 0;
        while (Math.pow(testsPerPig, pigs) < buckets) {
            pigs++;
        }

        return pigs;
    }
}
