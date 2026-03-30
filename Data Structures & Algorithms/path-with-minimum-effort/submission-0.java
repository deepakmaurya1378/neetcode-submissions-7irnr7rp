class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dis = new int[n][m];

        for(int[] x : dis){  Arrays.fill(x , (int)1e9); }

        dis[0][0] = 0;

        int[] r = {1, -1, 0, 0};
        int[] c = {0, 0, 1, -1};

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minheap.offer(new int[]{0,0,0});

        while(!minheap.isEmpty()){
            int[] curr = minheap.poll();
            int diff = curr[0];
            int r1 = curr[1];
            int c1 = curr[2];

            if(r1 ==  n-1 && c1 == m-1) return diff;
            if(dis[r1][c1] < diff) continue;

            for(int i=0; i<4; i++){
                int row = r[i] + r1;
                int col = c[i] + c1;

                if(row < 0 || col<0 || row >= n || col >= m){
                    continue;
                }
                int newdiff = Math.max(diff, Math.abs(heights[r1][c1] - heights[row][col]));

                if(diff < dis[row][col]){
                    dis[row][col] = newdiff;
                    minheap.offer(new int[]{newdiff, row, col});
                }
            }

        }
        return 0;  
    }
}