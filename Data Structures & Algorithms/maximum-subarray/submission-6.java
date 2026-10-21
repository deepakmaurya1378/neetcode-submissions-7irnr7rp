class Solution {
    private Integer[][] dp;
    public int maxsum(int[] nums, int i, boolean flag) {
        if (i == nums.length - 1) {
            return flag ? Math.max(0, nums[i]) : nums[i];
        }

        int f = flag ? 1 : 0;

        if (dp[i][f] != null) {
            return dp[i][f];
        }

        if (flag) {
            dp[i][f] = Math.max(
                0,
                nums[i] + maxsum(nums, i + 1, true)
            );
        } else {
            dp[i][f] = Math.max(
                maxsum(nums, i + 1, false),
                nums[i] + maxsum(nums, i + 1, true)
            );
        }

        return dp[i][f];
    }

    public int maxSubArray(int[] nums) {
        dp = new Integer[nums.length][2];
        int n = nums.length;
        dp[n-1][1] = Math.max(0, nums[nums.length-1]);
        dp[n-1][0] = nums[nums.length-1];
        for(int i = n - 2; i >= 0 ; i--){
            dp[i][1] = Math.max(0, nums[i] +dp[i + 1][1]);
            dp[i][0] = Math.max( dp[i + 1][0], nums[i] + dp[i + 1][1]);
        }
       return dp[0][0];
    }
}