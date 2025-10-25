class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true; // empty string matches empty pattern

        // Handle patterns like a*, a*b*, a*b*c* with empty string
        for (int j = 2; j <= n; j++)
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1), pc = p.charAt(j - 1);

                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1]; // current char matches
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 2]; // '*' as zero occurrence
                    if (p.charAt(j - 2) == sc || p.charAt(j - 2) == '.')
                        dp[i][j] |= dp[i - 1][j]; // '*' as one or more
                }
            }
        }

        return dp[m][n];
    }
}
