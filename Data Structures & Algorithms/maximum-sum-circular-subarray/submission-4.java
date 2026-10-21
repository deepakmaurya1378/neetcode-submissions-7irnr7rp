class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minsum = nums[0];
        int maxsum = nums[0];
        int c1 = 0;
        int c2 = 0;
        int totalsum = 0;
        for(int num : nums){
            c1 =  Math.min(c1+num, num);
            minsum =  Math.min(c1, minsum);
            
            c2 =  Math.max(c2+num, num);
            maxsum = Math.max(c2, maxsum);

            totalsum += num;
        }

         if (maxsum < 0) {
            return maxsum;
        }

        return Math.max(maxsum, totalsum - minsum);

    }
}