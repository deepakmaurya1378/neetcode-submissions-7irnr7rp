class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] a = new int[nums.length];
       int r = 1;
       int l = 1;
       for(int i=0;i<nums.length;i++ ){
           a[i] = l;
           l = nums[i]*l;
           // it will give all the element form left side 
       }
       for(int i=nums.length-1; i>= 0; i-- ){
           a[i] = r*a[i] ;
           r = nums[i]*r;
            // it will give all the element form right side 
       }
    
    return a;
    }
}  


   