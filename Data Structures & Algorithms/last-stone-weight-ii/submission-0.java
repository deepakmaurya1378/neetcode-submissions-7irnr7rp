class Solution {
    public int dfs(int ind, int[] nums, int[][] dp, int target){
        if(target == 0) return 0;
        if(ind ==  nums.length) return 0;
        if(dp[ind][target] != -1 ) return  dp[ind][target];
        int notake = dfs(ind+1, nums, dp, target);
        int take = 0;
        if(target >= nums[ind]){
            take = nums[ind] + dfs(ind+1, nums, dp , target - nums[ind]);
        }
        return dp[ind][target] = Math.max(take, notake);
    }

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0 ;
        for(int i : stones) sum += i;
        int target = sum/2;

        int[][] dp = new int[n][target+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int x = dfs(0,stones,dp, target);
        return  sum - 2*x;

    }
} 