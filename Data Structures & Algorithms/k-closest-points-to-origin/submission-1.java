class Solution {
    public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq =
    new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] ans = new int[k][2];
        ;
        int i = 0;
        for(int[] a: points){
            int x =a[0];
            int y =a[1];
            int dist = x*x + y*y;
            pq.add(new int[]{dist ,   i    });
            i++;
        }

        for(i=0; i< k; i++){
            int[] x = pq.poll();
            int j = x[1];
            ans[i][0] = points[j][0];
            ans[i][1] = points[j][1];
        }
        return ans;

    }
}
