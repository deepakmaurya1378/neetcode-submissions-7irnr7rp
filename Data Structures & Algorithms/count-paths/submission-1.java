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
       int prev[] = new int[n];
       for(int i = 0; i< n; i++){
        prev[i] = 1;
       }

       for(int i=1; i<m; i++){
        for(int j=0; j<n; j++){
            int down = 0;
            int right = 0;
            if(i < m){
                down = prev[j];
            }

            if(j < n && j > 0){
                right = prev[j-1];
            }
            prev[j] = down + right;

        }
       }

       return prev[n-1];
    }
}
