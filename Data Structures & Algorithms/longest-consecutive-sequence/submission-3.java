class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int m = 1;
        int c = 1;
        Arrays.sort(nums);
        for(int i=1;i < n; i++){
            if (nums[i-1] == (nums[i] - 1)){
                c++;
            }
            else if(nums[i-1] == nums[i]){
                c = c;
            }
            else {
                c = 1;
            }
           m = Math.max(m,c);
        }
        return m;
    }
}
