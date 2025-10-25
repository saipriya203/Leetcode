class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            int pop = x % 10;   // Get last digit
            x /= 10;            // Remove last digit
            
            // Check for overflow before multiplying by 10
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0; // Overflow
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0; // Underflow
            }
            
            rev = rev * 10 + pop;
        }
        
        return rev;
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverse(123));   // Output: 321
        System.out.println(sol.reverse(-123));  // Output: -321
        System.out.println(sol.reverse(120));   // Output: 21
        System.out.println(sol.reverse(0));     // Output: 0
        System.out.println(sol.reverse(1534236469)); // Output: 0 (overflow)
    }
}
