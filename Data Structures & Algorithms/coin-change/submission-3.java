class Solution {
    // public int count(int ind, int amount, int[][] dp, int[] coins){
    //     if(ind == 0){
    //         if(amount % coins[0] == 0)
    //             return amount / coins[0];
    //         else
    //             return (int)1e9;
    //     }
    //     if (dp[ind][amount] != -1) return dp[ind][amount];
    //     int notTake = count(ind-1, amount, dp , coins);
    //     int take =  (int)1e9;
    //     if(amount >= coins[ind]){
    //         take = 1 + count(ind, amount - coins[ind] ,dp, coins);
    //     }

    //     dp[ind][amount] = Math.min(take, notTake);
    //     return dp[ind][amount];

    // }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[]dp = new int[amount + 1];
        Arrays.fill(dp, -1);  

       for(int i = 0; i <= amount; i++){
            if(i % coins[0] == 0)
                dp[i] = i / coins[0];
            else
                dp[i] = (int)1e9;
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j <= amount; j++){
                int notTake = dp[j];
                int take = (int)1e9;
                if(j >= coins[i]){
                    take = 1 + dp[j - coins[i]];
                }
                dp[j] = Math.min(take, notTake);
            }
        }
        return dp[amount] >= 1e9 ? -1 : dp[amount];
    }
}
