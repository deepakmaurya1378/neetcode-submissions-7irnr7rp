class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        int m = 0;
        for(int i : nums){
            h.add(i);
        }
        for(int i : h){
            if(!h.contains(i-1)){
                int c = i;
                int l = 1;
                while(h.contains(c+1)){
                    c++;
                    l++;
                }
                 m =  Math.max(l , m);
            }
        }
        return m;
    }
}
