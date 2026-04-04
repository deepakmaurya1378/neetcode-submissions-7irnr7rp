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
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return dfs(0,0,text1, text2, dp);
    }
}
