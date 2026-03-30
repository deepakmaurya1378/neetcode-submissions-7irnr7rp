class Solution {
    public int[] plusOne(int[] digits) {
      int c = 1;
      
      for(int i=digits.length-1; i>=0; i--){
        if((digits[i]+c) >= 10){
          digits[i] = 0;
          c = 1;
        }
        else {
          digits[i] = digits[i] + c;
          c = 0;
          break;
        }
      }
      if(c == 0) return digits;
      else{
        int[] a = new int[digits.length+1];
        a[0] = 1;
        for(int i=1; i< a.length; i++){
          a[i] = 0;
        }
        return a;
      }
    }
}
