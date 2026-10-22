class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int tar = n-1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] + i >= tar){
                tar = i;
            }
        }

        return (tar == 0) ? true  : false;
    }
}


