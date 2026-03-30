class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int a[] = new int[256];
        for(int i = 0; i<s.length(); i++ ){
            a[s.charAt(i)]++;
            a[t.charAt(i)]--;
        }
        for(int i = 0; i<256; i++){
            if(a[i] != 0){
                return false;
            }
        }
        return true;
    }
}
