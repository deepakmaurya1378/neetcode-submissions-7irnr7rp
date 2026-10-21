class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxsum = nums[0];
        int n = nums.length;
        
        for(int i = 0 ; i  <  n; i++){
            int curr = 0;
            for(int j = i; j < i+n; j++){
                curr += nums[j%n];
                maxsum = Math.max(maxsum, curr);
            }
        }

        return maxsum;
    }
}