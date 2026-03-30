class Solution {
    class Pair{
        int cost;
        int dest;
        Pair(int cost, int dest){
            this.cost = cost;
            this.dest = dest;
        }
    }
    class tuple{
        int distance;
        int node;
        int stops;
        tuple(int distance, int node, int stops){
            this.distance = distance;
            this.node = node;
            this.stops = stops;
        }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            List<Pair> l = new ArrayList<>();
            graph.add(l);
        }
        
        for(int[] flight : flights){
            int src1 = flight[0];
            int dest = flight[1];
            int cost = flight[2];
            graph.get(src1).add(new Pair(cost, dest));
        }

        Queue<tuple> q = new LinkedList<>();

        q.add(new tuple(0,src,0));
        int reach[] = new int[n];
        Arrays.fill(reach, (int)1e9 );

        while(!q.isEmpty()){
            tuple t = q.poll();
            int dist = t.distance;
            int node = t.node;
            int stops = t.stops;

            if(stops > k) continue;

            for(int i=0; i<graph.get(node).size(); i++){
                Pair p = graph.get(node).get(i);
                int cost = p.cost;
                int dest = p.dest;

              if(dist + cost < reach[dest]){

                    reach[dest] = dist+cost;
                    q.add(new tuple(reach[dest], dest, stops+1));
                }

            }
        }
        if(reach[dst] == (int)1e9) return -1;
        return reach[dst];

    }
}
