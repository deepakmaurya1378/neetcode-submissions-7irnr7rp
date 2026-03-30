class Solution {
    public int dfs(int target, int[] nums, int[] dp){
        if(target < 0) return 0;
        if(target == 0) return 1;
        if(dp[target] != -1) return dp[target];
        int ways = 0;
        for(int num : nums){
            ways += dfs(target-num, nums, dp);
        }
        return dp[target] = ways;
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        return dfs(target, nums, dp);
        
    }
}