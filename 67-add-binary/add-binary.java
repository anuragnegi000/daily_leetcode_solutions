class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        // Traverse both strings from the rightmost digit to the leftmost
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            // Get the current digits from the strings, or assume 0 if we have reached the beginning of a string
            int digitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int digitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            // Calculate the sum of the current digits and the carry
            int sum = digitA + digitB + carry;

            // Update carry for the next calculation
            carry = sum / 2;

            // Append the current digit to the result
            result.insert(0, sum % 2);

            // Move to the next digits in the strings
            i--;
            j--;
        }

        // If there is still a carry, append it to the result
        if (carry > 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }
}
