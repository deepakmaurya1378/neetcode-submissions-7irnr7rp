class Solution {
    public boolean cycle(ArrayList<ArrayList<Integer>> g, boolean[] vis, int src, int parent){
        vis[src] = true;

        for (int nei : g.get(src)) {
            if (nei == parent) continue;
            if (vis[nei] || cycle(g, vis, nei, src)) {
                return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            g.get(u).add(v);
            g.get(v).add(u);

            boolean[] vis = new boolean[n + 1];

            if (cycle(g, vis, u, -1)) {
                return new int[]{u, v};
            }
        }
        return new int[0];
    }
}
