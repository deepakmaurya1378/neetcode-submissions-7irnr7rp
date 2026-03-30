class Solution {
    public void combination(int[] nums, List<List<Integer>> ans, List<Integer> l, int n, int c){
        if(c == n){
            ans.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[c]);
        combination(nums, ans, l, n, c+1);
        l.remove(l.size()-1);
        combination(nums, ans , l , n , c+1);
        return;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        combination(nums, ans , l , nums.length, 0);
        return ans;
    }
}
