class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
       
    ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<>();

        for(int i=0; i<=n; i++){
            graph.add(new HashMap<Integer,Integer>());
        }

        for(int[] i : times){
            int s = i[0];
            int d = i[1];
            int t = i[2];

            graph.get(s).put(d,t);

        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); 
        pq.add(new int[]{k, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if(time > dist[node]) continue;

            for(int nei : graph.get(node).keySet()) {
                int w = graph.get(node).get(nei);

                if(dist[nei] > time + w) {
                    dist[nei] = time + w;
                    pq.add(new int[]{nei, dist[nei]});
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++) ans = Math.max(ans, dist[i]);

        return ans == (int)1e9 ? -1 : ans;

                
    }
}
