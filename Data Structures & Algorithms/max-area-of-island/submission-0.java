class Solution {
     public int dfs(int[][] grid, boolean[][] vis, int r, int c , int n , int m){
        vis[r][c] = true;
        int s = 1;
        

        int[] row = {1, 0 , -1 , 0};
        int[] col = {0, -1, 0 , 1};

        for(int i = 0; i < 4; i++){
            if(row[i]+r < 0 || row[i]+r >= n || col[i]+c < 0 || col[i]+c >= m){
                continue;
            }
            else if (grid[row[i]+r][col[i]+c] == 1 && vis[row[i]+r][col[i]+c] == false){
               s+= dfs(grid ,vis , row[i]+r, col[i]+c, n , m);
            }
        }
        return s;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
           int n =  grid.length;
        int m = grid[0].length;
        
        boolean vis[][] = new boolean[n][m];

        int max = 0;
      

        for(int i = 0; i < n; i ++){
            for(int j=0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    int a = dfs(grid, vis, i, j , n , m );
                    max = Math.max(a, max);
                    
                }
            }
        }
        return max; 
        
    }
}
