class Solution {
    class Pair{
        int src;
        int dest;
        int time;
    public  Pair(int src, int dest, int time){
        this.src = src;
        this.dest = dest;
        this.time = time;
}

    }
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        int[][] vis = new int[n][m];

        int[] row = { -1 ,0 ,1 , 0};
        int[] col = { 0, -1, 0, 1};

        int countfresh = 0;

        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                if(grid[i][j] == 2){
                   q.add(new Pair(i,j,0));
                   vis[i][j] =2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    countfresh++;
                }
                
            }
        }

        int tm = 0;
        int count = 0;

        while(!q.isEmpty()){
            Pair p = q.remove();
            int src = p.src;
            int dest = p.dest;
            int time = p.time;

            tm = Math.max(time, tm);

            for(int i=0; i<4; i++){
                int r = src + row[i];
                int c = dest + col[i];
                if( r >= 0 && r < n  && c >= 0 && c < m && vis[r][c] != 2 && grid[r][c] == 1 ) {
                    q.add(new Pair(r, c, time + 1));

                    vis[r][c] = 2;
                    count++;
                } 
            }
        }


       if(count != countfresh) return -1;
       return tm;
 
        
    }
}
