class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
       int n = grid[0].length;
       int prev[] = new int[n];
       Arrays.fill(prev, 0);
       for(int i = 0; i< n; i++){
        if(i == 0) {
            prev[i] = grid[0][0];
            continue;
        }
        prev[i] = prev[i-1] + grid[0][i];
       }

       for(int i=1; i<m; i++){
        prev[0] += grid[i][0];
            for(int j=1; j<n; j++){
                int down = prev[j] + grid[i][j];
                int right = prev[j-1] + grid[i][j];

                prev[j] = Math.min(right, down);

            }
       }

       return prev[n-1];
    }
}
