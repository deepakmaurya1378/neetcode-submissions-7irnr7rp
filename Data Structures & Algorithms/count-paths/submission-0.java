class Solution {

    public int count(int m, int n,int i, int j, int[][] dp){
        if( i == m-1 && j == n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int down = 0; 
        int right = 0;
        if (i + 1 < m) 
                down = count(m, n, i + 1, j, dp);

        if (j + 1 < n) 
            right = count(m, n, i, j + 1, dp);
        dp[i][j] = down + right;
        System.out.println(dp[i][j] + " i = " + i + " j = " + j);
        return dp[i][j];

    }
    public int uniquePaths(int m, int n) {
        int[][]  dp = new int[m][n];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return count(m,n,0,0,dp);
    }
}
