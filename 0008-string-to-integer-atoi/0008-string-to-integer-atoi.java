class Solution {
    public int myAtoi(String s) {
        // Step 1: Trim leading spaces
        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If string is empty or only spaces
        if (i == n) return 0;

        // Step 2: Determine sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Step 4: Check for overflow before adding
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                // Overflow condition
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        // Step 5: Apply sign
        return result * sign;
    }

    // Optional test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("42"));           // Output: 42
        System.out.println(sol.myAtoi("   -042"));      // Output: -42
        System.out.println(sol.myAtoi("1337c0d3"));     // Output: 1337
        System.out.println(sol.myAtoi("0-1"));          // Output: 0
        System.out.println(sol.myAtoi("words and 987")); // Output: 0
        System.out.println(sol.myAtoi("-91283472332")); // Output: -2147483648 (clamped)
        System.out.println(sol.myAtoi("91283472332"));  // Output: 2147483647 (clamped)
    }
}
