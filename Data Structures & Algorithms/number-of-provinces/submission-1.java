class Solution {
    class DisjointSet{
        int[] parent;
        int[] rank;

        DisjointSet(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0; i<n ; i++){
                parent[i] = i;
                rank[i]=0;
            }
        }

        public int find(int n){
            if(parent[n] == n) return n;
            parent[n] = find(parent[n]);
            return parent[n];
        }

        public void Union(int x, int y){

            int px = find(x);
            int py = find(y);

            if(px == py) return;

            int rx = rank[px];
            int ry = rank[py];

            if(rx == ry){
                parent[py] = px; 
                rank[px]++;
            }
            else if(rx > ry){
                parent[py] = px;
            }
            else{
                parent[px] = py;
            }
        }
    }


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        DisjointSet d = new DisjointSet(n);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1){
                    d.Union(i, j);
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(d.find(i) == i){
                count++;
            }
        }
        return count;
    }
}