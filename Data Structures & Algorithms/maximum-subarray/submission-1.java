class Solution {
    public int maxSubArray(int[] nums) {
        int sum  = 0;
        int msum = Integer.MIN_VALUE;

        for(int num : nums){
            if(sum <= 0){
                sum = num;
            }
            else{
                sum = sum+num;
            }
            msum = Math.max(sum, msum);
        }
        return msum;
    }
}
