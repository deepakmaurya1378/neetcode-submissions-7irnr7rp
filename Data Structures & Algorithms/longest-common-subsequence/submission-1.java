class Solution {
    public int dfs(int i, int j, String s1, String s2, int[][] dp){
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + dfs(i+1, j+1, s1, s2, dp);
        }
        else{
            return dp[i][j] = Math.max(dfs(i, j+1, s1, s2, dp), dfs(i+1, j, s1, s2, dp));
        }
    }
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++ ){
            for(int j = 1 ; j <= m; j++){
                 if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];

    }
}
