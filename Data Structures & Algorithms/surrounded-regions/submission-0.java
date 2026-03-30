class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public void solve(char[][] board) {
       int n = board.length;
       int m = board[0].length;

       Queue<Pair> q = new LinkedList<>();
       boolean[][] vis = new boolean[n][m];

       for(int i=0; i <  n; i++){
            for(int j=0; j < m; j++){
              if( (i == 0 || i == n-1 || j == 0 || j == m-1 ) && board[i][j] == 'O'){
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                }
            else if(i == 0 || i == n-1 || j == 0 || j == m-1 ){
                vis[i][j] = true;
            }
        }}

       int[] r = { 1, -1, 0, 0};
       int[] c = { 0, 0, -1, 1};

       while(!q.isEmpty()){
        Pair p = q.poll();

        for(int k = 0; k < 4; k++ ){
             int row = p.i +  r[k];
             int col = p.j +  c[k];

            if((row >= 0 && row < n && col >= 0 && col < m ) && board[row][col] == 'O' && vis[row][col] == false){
                q.add(new Pair(row, col));
                vis[row][col] = true;
            }
        }
       }

       for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if (!vis[i][j]){
                    board[i][j] = 'X';
                }
            }
       }
    return;
    }
}
