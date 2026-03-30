class Solution {
    class Pair{
        int i;
        int j;
        int dist;
        Pair(int i, int j , int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 0){
                    q.add( new Pair(i, j, 0));
                }
            }
        }

        int[] r = {1 , 0, -1, 0};
        int[] c = {0, 1, 0, -1};

        while(!q.isEmpty()){

            Pair p = q.poll();
            int i = p.i;
            int j = p.j;
            int dist = p.dist;

            for(int k =0; k < 4; k++){
                int row = i+r[k];
                int col = j+c[k];
                if(row < 0 || row >= n || col < 0 || col >= m) {
                      continue;
                }
                else if(grid[row][col] > dist + 1){
                    q.add( new Pair(row,col, dist+1));
                    grid[row][col] = dist + 1;

                }
            }
        }

        return;
        
    }
}
