class Solution {
    public int findMin(int[] nums) {
       int j = nums.length - 1;
       int i = 0;
       int m = 0;
       
        while(j > i){
            m = (j+i)/2;
            if(nums[m] < nums[j]){
                j = m;
                
            }
            else{
               i = i+1;
            }
        
        }
        return nums[i];
    }
}
