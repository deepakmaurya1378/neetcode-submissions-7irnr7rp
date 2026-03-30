class Solution {
    class DisjointSet{
        int[] size;
        int[] parent;

        DisjointSet(int n){
            size = new int[n];
            parent = new int[n];
         for(int i = 0; i < n; i++){
    size[i] = 1;
    parent[i] = i;
}

        }

        public int findParent(int x){
            if(parent[x] == x){
                return x;
            }

            parent[x] = findParent(parent[x]);
            return parent[x];
        }

        public void UnionBysize(int x, int y){
            int px =findParent(x);
            int py =findParent(y);

            if(parent[px] == parent[py]) return;

            else if(size[px] >  size[py]){
                parent[py] = px;
                size[px] = size[px] + size[py];
            }
            else{
                parent[px] = py;
                size[py] = size[px]+size[py];
            }
        }
        
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        HashMap<String, Integer> h = new HashMap<>();

        int n = accounts.size();
        DisjointSet d = new DisjointSet(n);
        for(int i = 0; i < n; i ++ ){
            for(int j =1; j < accounts.get(i).size(); j++)
{
                if(!h.containsKey(accounts.get(i).get(j))){
                    h.put(accounts.get(i).get(j) , i);
                }
                else{
                    d.UnionBysize(i,h.get(accounts.get(i).get(j)));
                }
            }
        }
      
      List<String>[] storevalue = new ArrayList[n];


        for(int i=0; i<n; i++){
            storevalue[i] = new ArrayList<>();
        }

        for(Map.Entry<String, Integer> e : h.entrySet()){
            int parent = d.findParent(e.getValue());
            storevalue[parent].add(e.getKey());

        }

        int m = storevalue.length;
        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<m; i++){
            List<String> l = storevalue[i];
            Collections.sort(l);

         if(l != null && !l.isEmpty())
{
                l.add(accounts.get(i).get(0));
                ans.add(l);
            }


        }
        return ans;
        
    }
}