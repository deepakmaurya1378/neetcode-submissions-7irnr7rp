class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> h = new HashMap<>();
        List<Integer>[] a = new List[nums.length + 1];
          
        for (int i = 0; i < a.length; i++) {
            a[i] = new ArrayList<>();
        }


        for(int i =0;i<nums.length; i++){
            h.put(nums[i] , h.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> hm : h.entrySet()){
            a[hm.getValue()].add(hm.getKey());
        }

        int r[] = new int[k];
        int z = 0;

        for(int i = a.length-1; i > 0 && z < k ; i--){
            for(int j : a[i]){
                r[z++] = j;
                if(z == k){
                    return r;
                }
            }
        }
        return r;

    }
    
}
