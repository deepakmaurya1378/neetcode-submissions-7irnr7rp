class Solution {
    HashMap<String , PriorityQueue<String>> h = new HashMap<>();
    List<String> l = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for(List<String> t : tickets){
            h.putIfAbsent(t.get(0), new PriorityQueue<>()); 
            h.get(t.get(0)).offer(t.get(1));
        }

        dfs("JFK");
        Collections.reverse(l);
        return l;
       
    }

    public void dfs(String src){
        PriorityQueue<String> p = h.get(src);

        while(p != null && !p.isEmpty()){
            dfs(p.poll());
        }

        l.add(src);
    }
}
