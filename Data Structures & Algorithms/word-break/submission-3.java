class Solution {
    public int solve(int  ind, String s , List<String> dist, int[] dp){
        if(ind >=  s.length()) return 1;
        if(dp[ind] != -1) return dp[ind];
        int res = 0;
        for(String s1 : dist){
            int n = s1.length();
            if(ind+n <= s.length()){
            String s2 = s.substring(ind, ind + n );
            if(s1.equals(s2)){
                res = Math.max(res,solve(ind+n, s, dist, dp));
            }
        }
      }
        return dp[ind] = res;
    }
    public boolean wordBreak(String s, List<String> dist) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(int ind = n-1; ind >= 0 ; ind--){
            for(String s1 : dist){
            int n1 = s1.length();
               if(ind+n1 <= n){
                    String s2 = s.substring(ind, ind + n1);
                    if(s1.equals(s2) && dp[ind + n1]){
                        dp[ind] = dp[ind+n1];
                        break;
                    }
                }
           } 
        }
        return dp[0];
    }
}
