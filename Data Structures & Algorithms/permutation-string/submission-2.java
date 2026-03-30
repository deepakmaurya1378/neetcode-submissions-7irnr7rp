class Solution {
    public static boolean compare(int[] a, int[] b){
        for(int i =0 ; i< 26; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(m < n ) return false;
        int x[] = new int[26];
        int y[] = new int[26];
        for(int i = 0; i< n; i++){
            x[s1.charAt(i)-'a']++;
        }
        for(int i = 0; i< n; i++){
            y[s2.charAt(i)-'a']++;
        }
        int i = 0;
        int j = n;
        while(j < m){
            if(compare(x, y) == true){
                return true;
            }
            else{
                 y[s2.charAt(j)-'a']++;
                 y[s2.charAt(i)-'a']--;
                 j++;
                 i++;
            }
        }
        return compare(x, y);
    }
}
