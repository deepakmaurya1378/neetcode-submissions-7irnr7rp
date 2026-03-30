class Solution {

    int ans = Integer.MAX_VALUE;
    boolean[][] vis;

    public void dfs(int n, int i, int j, int curr, int[][] grid){
        if(i < 0 || j < 0 || i >= n || j >= n || vis[i][j]) return;
        curr = Math.max(curr, grid[i][j]);
       
        if(curr >= ans) return;

        if(i == n-1 && j == n-1){
            ans = Math.min(ans, curr);
            return;
        }

        vis[i][j] = true;

        int[] r = {1,-1,0,0};
        int[] c = {0,0,1,-1};

        for(int k=0; k<4; k++){
            dfs(n, i+r[k], j+c[k], curr, grid);
        }

        vis[i][j] = false; 
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        vis = new boolean[n][n];

        dfs(n, 0, 0, 0, grid);
        return ans;
    }
}
