class Solution {
    public int dPsol(int[] cost , int[] dp, int ind){
        if(ind > cost.length-1)  return 0;

        if(dp[ind] != -1) {
            return dp[ind] ;
        }
      
        int x = dPsol(cost, dp, ind+1);
        int y = dPsol(cost, dp, ind+2);
        return   dp[ind] = cost[ind] + Math.min(x,y);

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int min = Math.min(dPsol(cost, dp, 0),dPsol(cost, dp, 1 ));
        return min;

    }
}
