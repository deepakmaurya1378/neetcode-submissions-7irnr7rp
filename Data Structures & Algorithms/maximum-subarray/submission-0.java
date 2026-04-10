class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = 0;

        for(int num :  nums){
            curr += num;
            max = Math.max(curr, max);
            if(curr < 0){
                curr = 0;
            }
        }
        return max;
   }
}
