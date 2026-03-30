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
        int[][] dp = new int[n][sum + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int x =  dfs(0, n-1, nums, dp, sum);
        return (x == 0) ? false : true;
    }
}
