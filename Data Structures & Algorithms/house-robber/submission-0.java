class Solution {
    public int soluntion(int[] nums,int[] dp,int ind){
        if(nums.length-1 == ind){
            return nums[ind];
        }
        if(nums.length-1 < ind){
            return 0;
        }

        if(dp[ind] != -1 ) return dp[ind];

        int x = nums[ind] + soluntion(nums, dp, ind+2);
        int y =  soluntion(nums, dp , ind+1);

        dp[ind] = Math.max(x, y);

        return dp[ind];
    }

    public int rob(int[] nums) {
        int[]  dp = new int[nums.length+1];
        Arrays.fill( dp ,-1);
        return soluntion(nums, dp, 0);
    }
}
