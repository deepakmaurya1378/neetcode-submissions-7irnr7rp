class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int m = obstacleGrid.length;
       int n = obstacleGrid[0].length;
       int prev[] = new int[n];
       Arrays.fill(prev, 0);
       for(int i = 0; i< n; i++){
         if(obstacleGrid[0][i] == 1){
            break;
         }
         prev[i] = 1;
       }

       for(int i=1; i<m; i++){
        for(int j=0; j<n; j++){
            int down = prev[j];
            int right = 0;
            if( j > 0){
               right = prev[j-1]; 
            }

            if(obstacleGrid[i][j] == 1){
                    prev[j] =  0;
            }else{
            prev[j] = down + right;
            }

        }
       }

       return prev[n-1];
    }
}