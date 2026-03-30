public class Solution {
    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<int[]> p =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        boolean[][] vis = new boolean[n][n];

        p.offer(new int[]{grid[0][0], 0, 0});

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!p.isEmpty()){
            int[] curr = p.poll();

            int t = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(vis[r][c]) continue;
            vis[r][c] = true;

            if(r == n-1 && c == n-1) return t;

            for(int[] d : dir){
                int row = r + d[0];
                int col = c + d[1];

                if(row>=0 && col>=0 && row<n && col<n && !vis[row][col]){
                    p.offer(new int[]{
                        Math.max(t, grid[row][col]),
                        row,
                        col
                    });
                }
            }
        }

        return -1;
    }
}
