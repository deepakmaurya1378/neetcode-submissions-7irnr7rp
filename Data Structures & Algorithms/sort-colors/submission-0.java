class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i1 = 0;
        int i2 = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                i1++;
            } 
            if(nums[i] == 2){
                i2++;
            }
        }
        for(int i=n-1; i>=0; i--){
            if(i2 > 0){
                nums[i] = 2;
                i2--;
            }
            else if(i2 == 0 && i1 >0){
                nums[i] = 1;
                i1--;
            }
            else{
                nums[i] = 0;
            }
        }

        return;
            
    }
}