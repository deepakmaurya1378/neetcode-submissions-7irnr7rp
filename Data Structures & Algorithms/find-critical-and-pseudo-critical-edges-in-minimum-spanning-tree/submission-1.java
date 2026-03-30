class Solution {
   class DSU{
    private int n;
    private int[] parent , size;

    public DSU(int n){
        this.n = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py) {
            return false;
        }

        n--;

        if(size[px] < size[py]){
            int temp = px;
            px = py;
            py = temp;
        }

        size[px] +=size[py];
        parent[py] = px;
        return true;
    }

    public boolean isConnected(){
        return n==1;  // n component so n-1  edges so when the whole dsu is form value of n become one and if not mean mst is not possible.
    }
   }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

       for(int i=0;  i< edges.length; i++){
       edges[i] = Arrays.copyOf(edges[i] , edges[i].length + 1);
        edges[i][3] = i;
       }

       Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

       int mst_weight = find_Mst(n, edges, -1, false);

       List<Integer> critical = new ArrayList<>();
       List<Integer> pseduo = new ArrayList<>();

       for(int i=0; i<edges.length; i++){
        if(mst_weight  < find_Mst(n, edges, i, false)){ 
            critical.add(edges[i][3]);
        }
        else if(mst_weight == find_Mst(n, edges, i, true)){
            pseduo.add(edges[i][3]);
        }
       }

     List<List<Integer>> ans = new ArrayList<>();
            ans.add(critical);
             ans.add(pseduo);
           
            return ans;
    }

    public int find_Mst(int n, int[][] edges, int ind, boolean include){
        DSU d = new DSU(n);
        int wgt = 0;

        if(include){
            wgt += edges[ind][2];
            d.union(edges[ind][0], edges[ind][1]);
        }

        for(int i=0; i < edges.length; i++){
            if(i == ind){
                continue;
            }
            if(d.union(edges[i][0], edges[i][1])){
                wgt += edges[i][2];
            }
        }
        return d.isConnected() ? wgt : Integer.MAX_VALUE;
    }
}