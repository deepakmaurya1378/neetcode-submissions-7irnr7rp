class Solution {
    public int[] productExceptSelf(int[] nums) {
      int a[] = new int[nums.length];
      int p = 1;
      int c = 0;
      for(int i = 0; i < nums.length; i++){
          if(nums[i] != 0){
            p=p*nums[i];
        }else if(nums[i ] == 0){
            c++;
        }
      }
      if( c == 0){
        for(int i = 0; i < nums.length; i++){
              a[i] = p/nums[i];
        }
      }
      else if (c == 1){
         for(int i = 0; i < nums.length; i++){
              if( nums[i] == 0){
                a[i] = p;
              }
              else{
                a[i] = 0;
              }
        }
      }
      
     return a;
    }
}  


   