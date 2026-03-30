class Solution {
    public boolean dfs(List<List<Integer>> graph, int[] state, List<Integer> order, int node){
    state[node] = 1; // visiting

    for(int nei : graph.get(node)){
        if(state[nei] == 1) return false; // cycle
        if(state[nei] == 0){
            if(!dfs(graph, state, order, nei)) return false;
        }
    }

    state[node] = 2; // visited
    order.add(node);
    return true;
}
    
    public List<Integer> topsort(int[][] a, int k){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<k;i++){ graph.add(new ArrayList<>());   }
        for(int[] r: a){ graph.get(r[0] - 1).add(r[1] - 1);  }

        int[] vis = new int[k];
        List<Integer> Order = new ArrayList<>();
        for(int i=0; i<k; i++){
            if(vis[i] == 0){
                if(!dfs(graph, vis, Order , i)){ return new ArrayList<>();}
            }
        }
        Collections.reverse(Order);
        return Order;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        int[] rowPos = new int[k];
        int[] colPos = new int[k];

        List<Integer> rowOrder = topsort(rowConditions, k);
        List<Integer> colOrder = topsort(colConditions, k);

        if(rowOrder.size() == 0 || colOrder.size() == 0){
            return new int[0][0];
        }

        for(int i=0; i<k; i++){
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }

        int[][] res = new int[k][k];
        for(int i = 0; i < k; i++){
            res[rowPos[i]][colPos[i]] = i + 1;
        }

        return res; 
    }
}