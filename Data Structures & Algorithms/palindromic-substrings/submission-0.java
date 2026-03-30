class Solution {
    public int countSubstrings(String s) {
         int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count=0;
        for(int k=0; k<n; k++){
            for(int i=0,j=k; j<n; j++,i++){
                if(i-j == 0){
                    dp[i][j] = true;
                }
                else if(j-i == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else{
                    if( s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j] == true){
                    count++;
                }
            }
        }
        return count;
    }
}
