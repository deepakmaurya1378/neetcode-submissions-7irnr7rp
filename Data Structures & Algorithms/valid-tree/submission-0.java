class Solution {
    public boolean dfs(HashMap<Integer, List<Integer>> h, boolean[] vis, int src, int parent){
        vis[src] = true;

        for(int nei : h.get(src)){
            if(!vis[nei]){
                if(dfs(h, vis, nei, src)) return true;

            } else if(nei != parent){
                return true;  
            }
        }

        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> h = new HashMap<>();

        for(int i=0; i<n; i++){
            h.put(i, new ArrayList<>());
        }

        for(int[] a : edges){
            h.get(a[0]).add(a[1]);
            h.get(a[1]).add(a[0]);
        }

        boolean  vis[] = new boolean[n];

        if(dfs(h, vis, 0, -1)) return false;

        for(boolean v : vis){
            if(!v){
                return false;
            }
        }

    return true ;
    }
}
