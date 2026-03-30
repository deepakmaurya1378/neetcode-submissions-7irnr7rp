class Solution {
    public int findMin(int[] nums) {
       int j = nums.length - 1;
       int i = 0;
       
        while(j > i){
            int m = (j+i)/2;

            if(nums[m] > nums[j]){
                i = m + 1;
            }
            else{
                j = m;
            }
        
        }
        return nums[i];
    }
}
