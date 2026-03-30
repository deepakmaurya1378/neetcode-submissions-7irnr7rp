class Solution {
    public int count(int ind, int amount, int[][] dp, int[] coins){
        if(ind == 0){
            if(amount % coins[0] == 0)
                return amount / coins[0];
            else
                return (int)1e9;
        }
        if (dp[ind][amount] != -1) return dp[ind][amount];
        int notTake = count(ind-1, amount, dp , coins);
        int take =  (int)1e9;
        if(amount >= coins[ind]){
            take = 1 + count(ind, amount - coins[ind] ,dp, coins);
        }

        dp[ind][amount] = Math.min(take, notTake);
        return dp[ind][amount];

    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans =  count(n-1, amount , dp, coins);
        return ans >= 1e9 ? -1 : ans;
    }
}
