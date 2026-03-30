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
        if(s.charAt(0) == '0') return 0;
        int prev1 = 1;
        int prev2 = 1; 
    
        for(int ind = 1; ind <= n; ind++){
        int curr = 0;
        int one = 0;
        if(s.charAt(ind-1) != '0') one = prev1;
        int two = 0;
        if(ind-2 >= 0){
            int num = (s.charAt(ind-2) - '0') * 10 + (s.charAt(ind-1) - '0');
            if(num >= 10 && num <= 26){
                two = prev2;
            }
        }
        curr = one + two;
        prev2 = prev1;
        prev1 = curr;
        }

        return prev1;
    }
}
