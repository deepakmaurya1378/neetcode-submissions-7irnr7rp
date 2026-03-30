class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        for(int i : nums){
            h.add(i);
        }
        int longest = 0;
        for(int n : h){
            if(!h.contains(n-1)){
                int l = 1;
                while(h.contains(n+l)){
                    l++;
                }
                longest = Math.max(l , longest);
            }

        }
        return  longest;
    }
}
