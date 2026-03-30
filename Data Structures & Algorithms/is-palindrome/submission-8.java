class Solution {
    public boolean isPalindrome(String s) {
    s=s.toLowerCase();
    String s1 = s.replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = s1.length() - 1;
        while(j>i){
            if(s1.charAt(i) == s1.charAt(j)){
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
