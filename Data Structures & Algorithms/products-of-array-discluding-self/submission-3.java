class Solution {
    public int[] productExceptSelf(int[] nums) {
      int a[] = new int[nums.length];
      int l = 1;
      int r = 1;
      for(int i = 0; i < nums.length; i++){
        a[i] = l;
        l = nums[i] * l;
      }
      for(int i=nums.length-1; i>= 0; i-- ){
        a[i] = a[i]*r;
        r = r*nums[i];
       
      }
      return a;

    }
}  


   