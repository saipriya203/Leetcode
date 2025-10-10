class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        StringBuilder roman = new StringBuilder();

        // Loop through each symbol, subtracting values and appending symbols
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }

    // Example test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intToRoman(3749)); // Output: MMMDCCXLIX
        System.out.println(s.intToRoman(58));   // Output: LVIII
        System.out.println(s.intToRoman(1994)); 
        
    }
}