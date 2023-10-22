public class Solution {
  public int maximumScore(int[] nums, int k) {
    int ans = nums[k];
    int l = k, r = k, mn = nums[k];
    while (l > 0 || r + 1 < nums.length) {
      if (l == 0) {
        r++;
      } else if (r + 1 == nums.length) {
        l--;
      } else if (nums[l - 1] > nums[r + 1]) {
        l--;
      } else {
        r++;
      }
      mn = Math.min(mn, Math.min(nums[l], nums[r]));
      ans = Math.max(ans, mn * (r - l + 1));
    }
    return ans;
  }
}
