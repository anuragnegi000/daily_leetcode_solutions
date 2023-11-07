class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 0; // Index to store unique elements
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i]; // Overwrite the unique element
            }
        }

        // The unique elements are stored at indexes 0 to uniqueIndex (inclusive)
        // So, the length of the deduplicated array is uniqueIndex + 1
        return uniqueIndex + 1;
    }
}
