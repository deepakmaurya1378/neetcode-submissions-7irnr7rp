class Solution {
    public int dPsol(int[] cost , int[] dp, int ind){
        if(ind > cost.length-1)  return 0;
        if(dp[ind] != -1) {  return dp[ind] ; }    
        int x = dPsol(cost, dp, ind+1);
        int y = dPsol(cost, dp, ind+2);
        return   dp[ind] = cost[ind] + Math.min(x,y);
    }
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    
    int[] dp = new int[n];
    
    dp[0] = cost[0];
    dp[1] = cost[1];
    
    for(int i = 2; i < n; i++){
        dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
    }
    
    return Math.min(dp[n-1], dp[n-2]);
}
}
