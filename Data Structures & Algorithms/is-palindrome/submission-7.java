class Solution {
    public boolean isPalindrome(String s) {
    s=s.toLowerCase();
    StringBuilder z = new StringBuilder();
        for(int i=0;i<s.length();i++){
           if( Character.isDigit(s.charAt(i)) ||  Character.isLetter(s.charAt(i))){
               z.append(s.charAt(i));
           }
        }
        int i = 0;
        int j = z.length() - 1;
        while(j>i){
            if(z.charAt(i) == z.charAt(j)){
                i++;
                j--;
            }
            
            else{
                return false;
            }
        }
        return true;

    }
}
