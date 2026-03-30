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
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n];
            Arrays.fill(dp, -1);
        int x = solve(0, s, wordDict, dp);
        return (x == 0) ? false : true;


    }
}
