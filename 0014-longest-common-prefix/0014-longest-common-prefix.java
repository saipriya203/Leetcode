class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; // Start with the first string as the prefix

        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix until it matches the start of strs[i]
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return ""; // No common prefix
            }
        }

        return prefix;
    }

    // Local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestCommonPrefix(new String[]{"flower","flow","flight"})); // Output: "fl"
        System.out.println(sol.longestCommonPrefix(new String[]{"dog","racecar","car"}));   // Output: ""
        System.out.println(sol.longestCommonPrefix(new String[]{"interview","internet","internal"})); // Output: "inte"
    }
}
