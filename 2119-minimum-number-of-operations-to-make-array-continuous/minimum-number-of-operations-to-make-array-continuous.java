import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int m = removeDuplicates(nums);
        int n = nums.length;
        int ans = n;

        for (int i = 0; i < m; ++i) {
            int j = upperBound(nums, i, m, nums[i] + n - 1);
            ans = Math.min(ans, n - (j - i));
        }

        return ans;
    }

    // Helper method to remove duplicates and return the new size
    private int removeDuplicates(int[] nums) {
        int n = nums.length;
        int newSize = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[newSize++] = nums[i];
            }
        }

        return newSize;
    }

    // Helper method to find upper bound
    private int upperBound(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return  left;
    }
}
