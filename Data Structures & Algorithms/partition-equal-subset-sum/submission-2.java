class Solution {
    public int dfs(int ind , int n , int nums[], int[][] dp, int target){
           if(target == 0) return 1;
           if(ind == nums.length) return 0;

        if(dp[ind][target] != -1) return dp[ind][target];
        int notTake = dfs(ind+1, n, nums, dp, target);
        int take = 0;
        if(target >= nums[ind]){
            take = dfs(ind+1, n, nums, dp, target - nums[ind]);
        }
        return dp[ind][target] = take + notTake;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum  =  0;
        for(int i = 0; i < n; i++){
            sum +=  nums[i];
        }
        if(sum%2 == 1) return false;
        else sum = sum/2;
        boolean[][] dp = new boolean[n+1][sum + 1];
         for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for(int ind = n-1; ind >= 0; ind--){
            for(int target = 0; target <= sum; target++){
                boolean notTake = dp[ind+1][target];
                boolean take = false;
                if(target >= nums[ind]){
                    take = dp[ind+1][target - nums[ind]];
                }
            dp[ind][target] = take || notTake;
            }
        }
        return dp[0][sum];
       
    }
}
