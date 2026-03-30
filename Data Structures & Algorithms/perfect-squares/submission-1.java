class Solution {
    public int dfs(int ind, int n, int[] nums, int[][] dp, int target){
       if(ind == n) return (int)1e9; // impossible case
        if(target == 0) return 0;
        if(dp[ind][target] != -1) return dp[ind][target];
        int nottake = dfs(ind+1, n, nums, dp, target);
        int take = Integer.MAX_VALUE;
        if(target>= nums[ind]){
            take = 1 + dfs(ind, n, nums, dp, target-nums[ind]);
        }
        return dp[ind][target] = Math.min(take, nottake);
        
    }
    public int numSquares(int n) {
        int m = (int) Math.ceil(Math.sqrt(n));
        int nums[] = new int[m];
        for(int i=1; i<=m; i++ ){
            nums[i-1] = i*i;
        }
        int dp[][] = new int[m][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return dfs(0, m,nums, dp, n);
    }
}