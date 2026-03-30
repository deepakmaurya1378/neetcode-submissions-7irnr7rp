class Solution {
    public int solve(int ind, int n, int[] nums, int[] dp ){
        if(ind >= n) return 0;
        if(dp[ind] != (int)1e9 ) return dp[ind];
        int val =  nums[ind];
        int x = val - solve(ind+1, n, nums, dp);
        int y = Integer.MIN_VALUE;
        if(n>ind+1) y = val+nums[ind+1] - solve(ind+2,n, nums, dp);
        int z =  Integer.MIN_VALUE;
        if(n>ind+2 ) z = val+nums[ind+1] + nums[ind+2] - solve(ind+3, n, nums, dp);
         return dp[ind] = Math.max(x, Math.max(y, z));

    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n];
        Arrays.fill(dp, (int)1e9);
        int ans = solve(0,n,stoneValue,dp);
        if(ans == 0) return "Tie";
        return (ans > 0) ? "Alice" : "Bob";
        
    }
}