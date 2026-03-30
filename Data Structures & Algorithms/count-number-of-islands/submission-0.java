class Solution {

    public void dfs(char[][] grid, boolean[][] vis, int r, int c , int n , int m){
        vis[r][c] = true;

        int[] row = {1, 0 , -1 , 0};
        int[] col = {0, -1, 0 , 1};

        for(int i = 0; i < 4; i++){
            if(row[i]+r < 0 || row[i]+r >= n || col[i]+c < 0 || col[i]+c >= m){
                System.out.println(row[i]+r + " i and j " + col[i]+c );
                continue;
            }
            else if (grid[row[i]+r][col[i]+c] == '1' && vis[row[i]+r][col[i]+c] == false){
                dfs(grid ,vis , row[i]+r, col[i]+c, n , m);
            }
        }
        return;
    }
    
    public int numIslands(char[][] grid) {
        int n =  grid.length;
        int m = grid[0].length;
        
        boolean vis[][] = new boolean[n][m];
        int count =  0;

        for(int i = 0; i < n; i ++){
            for(int j=0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(grid, vis, i, j , n , m);
                    count++;
                }
            }
        }
        return count; 
    }
}
