class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        // Ensure nums1 is the smaller array for simplicity
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2;
        int left = (n + 1) / 2; // Length of the left half (median is either in left or both halves)

        int low = 0, high = n1;

        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = left - partition1;
            int maxLeft1 = (partition1 > 0) ? nums1[partition1 - 1] : Integer.MIN_VALUE;
            int minRight1 = (partition1 < n1) ? nums1[partition1] : Integer.MAX_VALUE;
            int maxLeft2 = (partition2 > 0) ? nums2[partition2 - 1] : Integer.MIN_VALUE;
            int minRight2 = (partition2 < n2) ? nums2[partition2] : Integer.MAX_VALUE;

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if (n % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }

        
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
