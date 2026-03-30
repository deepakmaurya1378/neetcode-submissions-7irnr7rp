class LRUCache {
    HashMap<Integer , Integer> h;
    ArrayList<Integer> list;
    int cap ;


    public LRUCache(int capacity) {
        h = new HashMap<>();
        list = new ArrayList<>();
        cap = capacity;
        
    }
    
    public int get(int key) {
        if (h.containsKey(key)){
            list.remove(Integer.valueOf(key));
            list.add(key);
            return h.get(key);
        }
        else{
            return -1;
        }
        
    }
    public void put(int key, int value) {
        if(!h.containsKey(key)){
          if (h.size() == cap) {
                h.remove(list.get(0));
                list.remove(0);
            }
            h.put(key, value);
            list.add(key);
        }
        else{
            list.remove(Integer.valueOf(key));
            list.add(key);
            h.put(key, value);
        }
    }
}
