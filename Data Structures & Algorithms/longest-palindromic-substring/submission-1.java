
class Solution {
    public int lcs(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + lcs(i - 1, j - 1, s1, s2, dp);
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j];
    }
    
    public String longestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n][n];
        for (int[] a : dp) {    Arrays.fill(a, -1);}

        int maxLen = 0;
        int endIndex = 0;
        
        // Find the longest common substring between s and its reverse
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == rev.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    
                    // Check if this common substring corresponds to a palindrome in original string
                    // Original index in s: i
                    // Original index in rev: j corresponds to n-1-j in original string
                    int originalStart = i - dp[i][j] + 1;
                    int reverseStart = n - 1 - j;
                    
                    // Check if it's a valid palindrome (indices should match)
                    if (originalStart == reverseStart && dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        // Extract the palindrome substring
        return s.substring(endIndex - maxLen + 1, endIndex + 1);
    }
}