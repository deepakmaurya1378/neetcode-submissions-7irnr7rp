class Solution {
    public String longestCommonPrefix(String[] strs) { 
       int n = strs.length;
       if(n==1) return strs[0];

       StringBuilder sb = new StringBuilder(strs[0]); 

       for(int i=1; i<n; i++){

        String s1 = strs[i];
        int m = Math.min(s1.length(), sb.length());

        if(m == 0) return "";
        for(int j=0; j<m;j++){
            if(s1.charAt(j) != sb.charAt(j)){
                sb.delete(j, sb.length()); 
                break;
            }

             if(j == m - 1) sb.setLength(m);  
        }

       }

       return sb.toString();
    }
}