class Solution {
    public int maxSubArray(int[] nums) {
       
        int n = nums.length;
        int dp1 = Math.max(0, nums[n-1]);
        int dp0 = nums[n-1];
        for(int i = n - 2; i >= 0 ; i--){
            int olddp = dp1;
            dp0 = Math.max( dp0, nums[i] + olddp);
            dp1 = Math.max(0, nums[i] +olddp);
        }
       return dp0;
    }
}