class Solution {
    class DSU{
        int[] parent;
        int[] size;

        DSU(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++){
                parent[i]=i;
                size[i] = 1;
            }
        }

        int find(int n){
            if(parent[n] == n) return n;
            parent[n] = find(parent[n]);
            return parent[n];  
        }

        boolean Union(int i, int j){
            int pi = find(i);
            int pj = find(j);

            if(pi == pj) return  false;
            
            if(size[pi] >= size[pj]){
                parent[pj] = pi;
                size[pi] = size[pi] + size[pj];
                return true;
            }
            else{
                parent[pi] = pj;
                size[pj]+= size[pi];
                return true;
            }
        }
    }
    public int minCostConnectPoints(int[][] points) {

        List<int[]> edges = new ArrayList<>();
        int n = points.length;
        DSU d = new DSU(n);

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n ; j ++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]) ;
                edges.add(new int[] {dist, i , j});
            }
        }
    
      edges.sort((a, b) -> Integer.compare(a[0], b[0]));

      int res = 0;
      for(int[] edge: edges){
        if(d.Union(edge[1], edge[2])){
            res+=edge[0];
        }
      }
    return res;
    }
}
