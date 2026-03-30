class Solution {
    public int majorityElement(int[] nums) {
        int c = 0;
        int r = nums[0];

        for(int i : nums){
            if(c == 0){  r = i; }
            c +=  (i==r) ? 1 : -1;
        }

        return r;
    }
}