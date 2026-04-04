class Solution {
    public int dfs(int n,int[] dp){
        if(n < 2) return  n;
        if(dp[n] != -1) return dp[n];
        int max = 0;

        for (int i = 1; i < n; i++) {
            int notBreak = i * (n - i);
            int breakFurther = i * dfs(n - i, dp);

            max = Math.max(max, Math.max(notBreak, breakFurther));
        }

        return dp[n] = max;
    }
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return dfs(n, dp);
    }
}