class Solution {
    public int soluntion(int[] nums,int[] dp,int ind){
        if(nums.length-1 == ind){   return nums[ind];}
        if(nums.length-1 < ind){   return 0;  }
        if(dp[ind] != -1 ) return dp[ind];
        int x = nums[ind] + soluntion(nums, dp, ind+2);
        int y =  soluntion(nums, dp , ind+1);
        dp[ind] = Math.max(x, y);
        return dp[ind];
    }

    public int rob(int[] nums) {
        // return soluntion(nums, dp, 0);
        int prev1 = nums[0];
        int prev2 = 0;
        for(int i=1; i<nums.length; i++){
            int take = nums[i];
            if(i>1) {
                take += prev2;
            }
            int notake = prev1;
            prev2 = prev1;
            prev1 = Math.max(take , notake);

        }
        return prev1;
    }
}
