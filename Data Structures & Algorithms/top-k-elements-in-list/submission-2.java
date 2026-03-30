class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> h = new HashMap<>(); // creating hashmap for key and it freq
        List<Integer>[] l= new List[nums.length+1] ;

        for (int i = 0; i < l.length; i++) {
            l[i] = new ArrayList<>();
        }
        
        for(int i : nums){
           h.put(i , h.getOrDefault(i,0)+1);
        }
       
        for(Map.Entry<Integer, Integer> hm : h.entrySet()){
           l[hm.getValue()].add(hm.getKey());
         }

        int[] r = new int[k];
        int z=0;
        for(int i=l.length-1; i>0 && z<k ; i--){
            for(int j : l[i]){
                r[z++] = j;
                if(z==k){
                    return r;
                }
            }

        }
        return r;
    }
}
