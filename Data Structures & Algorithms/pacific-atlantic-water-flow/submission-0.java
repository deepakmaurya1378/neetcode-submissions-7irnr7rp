class Solution {

    public void dfs(int[][] heights,  boolean[][] v, int n, int m, int i , int j){
       if (v[i][j] == true) return;
        v[i][j] = true;

        int[] r = {1, -1, 0, 0};
        int[] c = {0, 0, -1, 1};

        for(int k = 0; k < 4; k++){
            int row = i + r[k];
            int col = j + c[k];

            if((row <  n && row >= 0 && col >= 0 && col < m) && heights[i][j] <= heights[row][col]){
                dfs(heights, v, n, m, row, col);
            }
        }

        return;

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        List<List<Integer>> l = new ArrayList<>();

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

       
            for(int j = 0; j < m; j++){
                dfs(heights, pacific, n, m , 0 , j);
                dfs(heights, atlantic, n, m , n-1 , j);
            }
        

        for(int i = 0; i < n; i++){
                dfs(heights, pacific, n, m , i , 0);
                dfs(heights, atlantic, n, m , i , m-1);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] ==  true && atlantic[i][j] == true){
                    List<Integer> cell = new ArrayList<>();
                            cell.add(i);
                            cell.add(j);
                            l.add(cell);

                }
            }
        }

        return l;
        
    }
}
