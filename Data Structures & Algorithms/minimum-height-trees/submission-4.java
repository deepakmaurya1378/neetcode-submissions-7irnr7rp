class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
          if (n == 1) return Arrays.asList(0);
        List<List<Integer>> l = new ArrayList<>();

        for(int i=0; i<n; i++){
            l.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int[] edge: edges){
            int i = edge[0];
            int j = edge[1];

            l.get(i).add(j);
            l.get(j).add(i);

            indegree[i]++;
            indegree[j]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(indegree[i] == 1) {
                q.add(i);
            }
        }

        int size = n;

        while(size > 2){
            int z = q.size();
            size -= z;

            for(int i=0; i<z; i++){
                int leaf = q.poll();

                for(int j : l.get(leaf)){
                    indegree[j]--;
                    if(indegree[j] == 1) {
                        q.add(j);
                    }
                }
            }
        }

         return new ArrayList<>(q);
       
    }
}