class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        // Binary search to find the peak of the mountain.
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int peak = left; // Index of the peak element.

        // Binary search on the left side of the peak (ascending part).
        left = 0;
        right = peak;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Binary search on the right side of the peak (descending part).
        left = peak;
        right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; // Target not found in the mountain array.
    }
}
