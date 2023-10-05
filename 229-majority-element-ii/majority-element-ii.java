class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
         List<Integer> result = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int majorEL1 = 0, majorEL2 = 0;

        for (int num : nums) {
            if (num == majorEL1) {
                count1++;
            } else if (num == majorEL2) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                majorEL1 = num;
            } else if (count2 == 0) {
                count2 = 1;
                majorEL2 = num;
            } else {
                count1--;
                count2--;
            }
        }

       
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == majorEL1) {
                count1++;
            } else if (num == majorEL2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            result.add(majorEL1);
        }
        if (count2 > nums.length / 3) {
            result.add(majorEL2);
        }

        return result;
    }
}