class Solution {
    public int solve(int ind, int n , String s, int[] dp){
        if(ind >= n) return 1;
        if(s.charAt(ind) == '0') return 0;
    
        if(dp[ind] != -1) return dp[ind];
        int one = solve(ind+1, n, s, dp);
        int two = 0;
       if(ind + 1 < n){
            int num = (s.charAt(ind) - '0') * 10 + (s.charAt(ind+1) - '0');
            if(num >= 10 && num <= 26){
                two = solve(ind + 2, n, s, dp);
            }
        }
        return dp[ind] = one + two;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, n, s, dp);
        
    }
}
